package org.ihfms.ihfms.service.factories;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.ihfms.ihfms.controllers.dtos.PatientRequest;
import org.ihfms.ihfms.entity.InPatient;
import org.ihfms.ihfms.entity.OutPatient;
import org.ihfms.ihfms.entity.Patient;
import org.ihfms.ihfms.entity.User;
import org.ihfms.ihfms.repositories.OutPatientRepository;
import org.ihfms.ihfms.repositories.PatientRepository;
import org.ihfms.ihfms.service.BedService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PatientFactoryImpl implements PatientFactory{
	private final PatientRepository patientRepository;
	private final OutPatientRepository outPatientRepository;
	private final BedService bedService;
	@Override
	public void createOutpatient(PatientRequest request) {
//		 Patient outPatient = new OutPatient(request.getFirstName(), request.getLastName(),
//				 request.getEmail(),  request.getPhoneNum(),
//				 request.getAdmissionDate(),request.getAge(),request.getGender()
//				 );
//		 patientRepository.save(outPatient);
		 
		 var patient = OutPatient.builder()
				 .firstName(request.getFirstName())
				 .lastName(request.getLastName())
				 .email(request.getEmail())
				 .phoneNum(request.getPhoneNum())
				 .admissionDate(request.getAdmissionDate())
				 .age(request.getAge())
				 .patientType(request.getPatientType())
				 .gender(request.getGender())
				 .bed(null)
				 .roomNumber(null)
				 .build();
		 patientRepository.save(patient);
		 
		 
		 
			
	}
	
	
	
	@Override
	public void createInPatient(PatientRequest request) {
//		InPatient inPatient =  new InPatient(request.getFirstName(), request.getLastName(),
//				request.getEmail(), request.getPhoneNum(), request.getPhoneNum(),
//				request.getAdmissionDate(),request.getAge(),request.getGender()
//		);
//		bedService.assignBedToInpatient(inPatient);
//		patientRepository.save(inPatient);
		var patient = Patient.builder()
				.firstName(request.getFirstName())
				.lastName(request.getLastName())
				.email(request.getEmail())
				.phoneNum(request.getPhoneNum())
				.admissionDate(request.getAdmissionDate())
				.age(request.getAge())
				.patientType(request.getPatientType())
				.gender(request.getGender())
				.build();
		bedService.assignBedToInpatient(patient);
		patientRepository.save(patient);
	
	
	}
}
