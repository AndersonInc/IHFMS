package org.ihfms.ihfms.service.dataValidators;

import java.time.LocalDate;
import java.util.Date;

import org.ihfms.ihfms.controllers.dtos.PatientRequest;
import org.ihfms.ihfms.entity.Gender;
import org.ihfms.ihfms.entity.PatientType;

public class DataValidatorImpl implements DataValidator{
	
	@Override
	public PatientRequest validatePatientData(PatientRequest request) {
		if (request==null || request.getFirstName() == null ||
				request.getFirstName().trim().isEmpty())
			throw new IllegalStateException("First Name cannot be  empty");
		else if (request.getLastName() == null || request.getLastName().trim()
				.isEmpty())throw new IllegalStateException(
						"Last name cannot be empty");
		else if (request.getEmail() == null || request.getEmail()
				.trim().isEmpty()) {
			throw new IllegalStateException("Email cannot be empty");
			
		} else if (request.getAge() <= 0) {
			throw new IllegalStateException("Age can not be less than or Equal to zero");
		} else if (request.getPhoneNum() == null || request.getPhoneNum()
				.trim().isEmpty()) {
			throw new IllegalStateException("Phone number cannot be empty");
		} else if ((request.getAdmissionDate() == null) || request.getAdmissionDate()
				.isAfter(LocalDate.now())){
			throw new IllegalStateException("The date can not be beyond today");
			
		} else if (request.getGender()!= null){
			if (request.getGender().toString().equalsIgnoreCase("female")){
				request.setGender(Gender.FEMALE);
			}else request.setGender(Gender.MALE);
		} else if (request.getPatientType() != null) {
			if (request.getPatientType().toString().equalsIgnoreCase("inpatient")){
				request.setPatientType(PatientType.INPATIENT);
			}else request.setPatientType(PatientType.OUTPATIENT);
			
		}
		
		return request;
			
	}
		
	
}
