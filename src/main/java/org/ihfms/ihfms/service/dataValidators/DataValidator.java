package org.ihfms.ihfms.service.dataValidators;

import org.ihfms.ihfms.controllers.dtos.PatientRequest;
import org.springframework.stereotype.Component;

@Component
public interface DataValidator {
	 PatientRequest validatePatientData(PatientRequest request);
	
}
