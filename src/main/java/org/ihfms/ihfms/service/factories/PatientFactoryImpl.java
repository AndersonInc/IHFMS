package org.ihfms.ihfms.service.factories;

import lombok.RequiredArgsConstructor;
import org.ihfms.ihfms.controllers.dtos.PatientRequest;
import org.ihfms.ihfms.entity.InPatient;
import org.ihfms.ihfms.entity.OutPatient;
import org.ihfms.ihfms.entity.Patient;
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
		 Patient outPatient = new OutPatient(request.getFirstName(), request.getLastName(),
				 request.getEmail(), request.getPhoneNum(), request.getPhoneNum(),
				 request.getAdmissionDate(),request.getAge(),request.getGender()
				 );
		 patientRepository.save(outPatient);
	}
	
	
	
	@Override
	public void createInPatient(PatientRequest request) {
		InPatient inPatient = new InPatient(request.getFirstName(), request.getLastName(),
				request.getEmail(), request.getPhoneNum(), request.getPhoneNum(),
				request.getAdmissionDate(),request.getAge(),request.getGender()
		);
		bedService.assignBedToInpatient(inPatient);
		patientRepository.save(inPatient);
	
	}
}
