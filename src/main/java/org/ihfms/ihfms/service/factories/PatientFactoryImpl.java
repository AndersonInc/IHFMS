package org.ihfms.ihfms.service.factories;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.ihfms.ihfms.controllers.dtos.PatientRequest;
import org.ihfms.ihfms.entity.Patient;
import org.ihfms.ihfms.repositories.PatientRepository;

@AllArgsConstructor
@RequiredArgsConstructor
public class PatientFactoryImpl implements PatientFactory{
	private final PatientRepository patientRepository;
	@Override
	public void createOutpatient(PatientRequest request) {
		 var patient = Patient.builder()
				 .firstName(request.getFirstName())
				 .lastName(request.getLastName())
				 .email(request.getEmail())
				 .phoneNum(request.getPhoneNum())
				 .admissionDate(request.getAdmissionDate())
				 .age(request.getAge())
				 .gender(request.getGender())
				 .build();
		 patientRepository.save(patient);
	}
	
	
	
	@Override
	public void createInPatient(PatientRequest patientRequest) {
	
	}
}
