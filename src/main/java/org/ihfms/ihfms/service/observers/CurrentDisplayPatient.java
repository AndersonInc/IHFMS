package org.ihfms.ihfms.service.observers;

import java.util.Observable;
import java.util.Observer;

import org.ihfms.ihfms.entity.Bed;
import org.ihfms.ihfms.entity.Patient;
import org.ihfms.ihfms.entity.Room;

public class CurrentDisplayPatient implements Observer,DisplayElements {
	Observable observable;
	Patient patient;
	Room room;
	Bed bed;
	CurrentDisplayPatient(Observable observable){
		this.observable = observable;
		observable.addObserver(this);
	
	}
	
	@Override
	public void update(Observable obs, Object arg) {
		if (obs instanceof SubjectPatient){
			SubjectPatient subjectPatient = (SubjectPatient) obs;
			patient = subjectPatient.getPatient();
			room = subjectPatient.getRoom();
			bed = subjectPatient.getBed();
			display();
		
		}
	
	}
	
	@Override
	public void display() {
		System.out.println("Patient: "+patient.getFirstName()+" has been added");
	}
}
