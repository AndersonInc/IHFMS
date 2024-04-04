package org.ihfms.ihfms.service.dataValidators;

import org.ihfms.ihfms.controllers.dtos.PatientRequest;

public interface DataValidator {
	 PatientRequest validatePatientData(PatientRequest request);
	
}
