package org.ihfms.ihfms.service;

import org.ihfms.ihfms.entity.Bed;
import org.ihfms.ihfms.entity.InPatient;
import org.ihfms.ihfms.entity.Patient;

public interface BedService {
	Bed assignBedToInpatient(Patient inpatient);
	void releaseBed(InPatient inpatient);
}
