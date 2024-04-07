package org.ihfms.ihfms.service;

import org.ihfms.ihfms.entity.Bed;
import org.ihfms.ihfms.entity.InPatient;

public interface BedService {
	Bed assignBedToInpatient(InPatient inpatient);
	void releaseBed(InPatient inpatient);
}
