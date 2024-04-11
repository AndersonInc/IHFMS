package org.ihfms.ihfms.service.factories;

import lombok.RequiredArgsConstructor;
import org.ihfms.ihfms.controllers.dtos.PatientRequest;
import org.ihfms.ihfms.entity.InPatient;
import org.ihfms.ihfms.entity.OutPatient;
import org.ihfms.ihfms.repositories.PatientRepository;
import org.ihfms.ihfms.service.BedService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PatientFactoryImpl implements PatientFactory{
	private final PatientRepository patientRepository;
	private final BedService bedService;
	@Override
	public void createOutpatient(PatientRequest request) {
		 var patient = new OutPatient();
		 patient.setFirstName(request.getFirstName());
		 patient.setLastName(request.getLastName());
		 patient.setEmail(request.getEmail());
		 patient.setPhoneNum(request.getPhoneNum());
		 patient.setAdmissionDate(request.getAdmissionDate());
		 patient.setGender(request.getGender());
		 patient.setAge(request.getAge());
		 patient.setPatientType(request.getPatientType());
		 patientRepository.save(patient);
	}
	
	
	
	@Override
	public void createInPatient(PatientRequest request) {
		InPatient inPatient =  new InPatient();
		inPatient.setFirstName(request.getFirstName());
		inPatient.setLastName(request.getLastName());
		inPatient.setEmail(request.getEmail());
		inPatient.setPhoneNum(request.getPhoneNum());
		inPatient.setPatientType(request.getPatientType());
		inPatient.setAdmissionDate(request.getAdmissionDate());
		inPatient.setAge(request.getAge());
		inPatient.setGender(request.getGender());
		bedService.assignBedToInpatient(inPatient);
	}
}
