package org.ihfms.ihfms.service;

import lombok.AllArgsConstructor;
import org.ihfms.ihfms.entity.Bed;
import org.ihfms.ihfms.entity.InPatient;
import org.ihfms.ihfms.entity.Room;
import org.ihfms.ihfms.repositories.BedRepository;
import org.ihfms.ihfms.repositories.RoomRepository;
import org.ihfms.ihfms.service.factories.observer.BedObserver;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class BedServiceImpl implements BedService{
	
	private final RoomRepository roomRepository;
	private final BedRepository bedRepository;
	private final BedObserver bedObserver;
	
	@Override
	public Bed assignBedToInpatient(InPatient inpatient) {
		Room room = roomRepository.findFirstByAvailableBedsGreaterThan(0);
		if (room != null) {
			Bed bed = room.getBeds().stream().filter(b -> !b.isOccupied()).findFirst().orElse(null);
			if (bed != null) {
				bed.setOccupied(true);
				bed.setInpatient(inpatient);
				inpatient.setBed(bed);
				room.setAvailableBeds(room.getAvailableBeds() - 1);
				bed.setBedNumber(generateBedNumber(room, bed));
				bedRepository.save(bed);
				roomRepository.save(room);
				bedObserver.notifyObservers(bed);
				return bed;
			}
		}
		return null;
	}
	
	
	// Helper method to generate bed number
	private String generateBedNumber(Room room, Bed bed) {
		return room.getRoomNumber() + "-" + (room.getTotalBeds() -
				room.getAvailableBeds() + 1);
	}
	
	@Override
	public void releaseBed(InPatient inpatient) {
		Bed bed = inpatient.getBed();
		if (bed != null && bed.isOccupied()) {
			bed.setOccupied(false);
			bed.setInpatient(null);
			Room room = bed.getRoom();
			room.setAvailableBeds(room.getAvailableBeds() + 1);
			bedRepository.save(bed);
			roomRepository.save(room);
			bedObserver.notifyObservers(bed);
		}
	
	}
}
