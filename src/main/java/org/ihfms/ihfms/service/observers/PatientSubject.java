package org.ihfms.ihfms.service.observers;

public interface PatientSubject {
	void registerObserver(PatientObserver patientObserver);
	
	void removeObserver(PatientObserver patientObserver);
	
	public void notifyObserver();

}
