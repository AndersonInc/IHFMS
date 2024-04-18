package org.ihfms.ihfms.service.observers;

import java.util.ArrayList;

import lombok.Setter;
import org.ihfms.ihfms.entity.Bed;
import org.ihfms.ihfms.entity.Patient;
import org.ihfms.ihfms.entity.Room;

public class PatientSubjectImpl implements PatientSubject{
	
	private ArrayList<PatientObserver> observers;
	@Setter
	private Bed bed;
	@Setter
	private Room room;
	@Setter
	private Patient patient;
	
	PatientSubjectImpl(){
		observers = new ArrayList<PatientObserver>();
	}
	
	@Override
	public void registerObserver(PatientObserver patientObserver) {
		observers.add(patientObserver);
	
	}
	
	@Override
	public void removeObserver(PatientObserver patientObserver) {
		int i = observers.indexOf(patientObserver);
		if (i>=0){
		observers.remove(patientObserver);
		}
	}
	
	@Override
	public void notifyObserver() {
		for (PatientObserver observer:observers
		     ) {
			observer.update(patient,bed,room);
			observer.update(patient);
		}
	
	}
	public void patientAdded(){
		notifyObserver();
	}
	
	
}
