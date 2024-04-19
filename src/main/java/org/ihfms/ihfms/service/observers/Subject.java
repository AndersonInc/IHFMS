package org.ihfms.ihfms.service.observers;

import org.ihfms.ihfms.entity.Bed;
import org.ihfms.ihfms.entity.Patient;
import org.ihfms.ihfms.entity.Room;

public interface Subject {
	public void setParameters(Patient patient);
	public void setParameters(Patient patient, Room room, Bed bed);
	
}
