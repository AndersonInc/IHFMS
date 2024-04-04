package org.ihfms.ihfms.service;

import org.ihfms.ihfms.controllers.dtos.PatientRequest;
import org.springframework.stereotype.Service;

@Service
public interface PatientService {
	void createPatient(PatientRequest patientRequest);

}
