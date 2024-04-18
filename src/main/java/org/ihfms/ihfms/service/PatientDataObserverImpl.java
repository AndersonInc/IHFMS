package org.ihfms.ihfms.service;

import org.ihfms.ihfms.entity.Bed;
import org.ihfms.ihfms.entity.Patient;
import org.ihfms.ihfms.entity.Room;
import org.ihfms.ihfms.service.observers.PatientObserver;
import org.ihfms.ihfms.service.observers.PatientSubject;

public class PatientDataObserverImpl implements PatientObserver {
	Patient patient;
	Room room;
	Bed bed;
	private PatientSubject patientSubject;
	PatientDataObserverImpl(PatientSubject patientSubject){
		this.patientSubject = patientSubject;
		patientSubject.registerObserver(this);
		
	}
	
	@Override
	public void update(Patient patient, Bed bed, Room room) {
	
	}
	
	@Override
	public void update(Patient patient) {
	
	}
}
