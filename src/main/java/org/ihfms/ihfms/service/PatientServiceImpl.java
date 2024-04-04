package org.ihfms.ihfms.service;

import lombok.AllArgsConstructor;
import org.ihfms.ihfms.controllers.dtos.PatientRequest;
import org.ihfms.ihfms.entity.PatientType;
import org.ihfms.ihfms.service.dataValidators.DataValidator;
import org.ihfms.ihfms.service.factories.PatientFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService{
	private final DataValidator dataValidator;
	private final PatientFactory patientFactory;
	
	@Override
	public void createPatient(PatientRequest patientRequest) {
		var patient = dataValidator.validatePatientData(patientRequest);
		if (patient.getPatientType().equals(PatientType.INPATIENT)){
			patientFactory.createInPatient(patient);
		}else patientFactory.createOutpatient(patient);
	}
}
