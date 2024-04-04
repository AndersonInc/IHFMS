package org.ihfms.ihfms.service.factories;

import org.ihfms.ihfms.controllers.dtos.PatientRequest;

public interface PatientFactory {
	void createOutpatient(PatientRequest patientRequest);
	void createInPatient(PatientRequest patientRequest);
	
}
