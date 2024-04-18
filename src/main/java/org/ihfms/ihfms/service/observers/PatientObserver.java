package org.ihfms.ihfms.service.observers;

import org.ihfms.ihfms.entity.Bed;
import org.ihfms.ihfms.entity.Patient;
import org.ihfms.ihfms.entity.Room;

public interface PatientObserver {
	void update(Patient patient,Bed bed, Room room);
	void update(Patient patient);
	
}
