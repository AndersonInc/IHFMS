package org.ihfms.ihfms.service;

import lombok.AllArgsConstructor;
import org.ihfms.ihfms.entity.Bed;
import org.ihfms.ihfms.entity.InPatient;
import org.ihfms.ihfms.entity.Room;
import org.ihfms.ihfms.repositories.BedRepository;
import org.ihfms.ihfms.repositories.PatientRepository;
import org.ihfms.ihfms.repositories.RoomRepository;
import org.ihfms.ihfms.service.factories.observer.BedObserver;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class BedServiceImpl implements BedService{
	
	private final RoomRepository roomRepository;
	private final BedRepository bedRepository;
	private final BedObserver bedObserver;
	private final PatientRepository patientRepository;
	
	
	@Override
	public Bed assignBedToInpatient(InPatient inpatient) {
		Room room = roomRepository.findFirstByAvailableBedsGreaterThan(0);
		//System.out.println("Found "+bed.getBedNumber()+ "in "+room.getRoomNumber());
		if (room != null){
			System.out.println("Found some rooms "+room.getRoomNumber());
			Bed bed = room.getBeds().stream().filter(b -> !b.isOccupied()).findFirst().orElse(null);
			if (bed != null) {
				bed.setOccupied(true);
				bed.setInpatient(inpatient);
				inpatient.setBed(bed);
				room.setAvailableBeds(room.getAvailableBeds() - 1);
				bed.setBedNumber(generateBedNumber(room, bed));
				inpatient.setRoomNumber(room.getRoomNumber());
				System.out.println("Found some beds, assigned somebody a bed!");
				patientRepository.save(inpatient);
				bedRepository.save(bed);
				roomRepository.save(room);
				System.out.println("saved the patient: "+inpatient);
				bedObserver.notifyObservers(bed);
				return bed;
			}
		}return null;
	}
	
	
	
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
