package org.ihfms.ihfms.service.observers;

import java.util.Observable;

import lombok.Getter;
import org.ihfms.ihfms.entity.Bed;
import org.ihfms.ihfms.entity.Patient;
import org.ihfms.ihfms.entity.Room;

public class SubjectPatient extends Observable implements Subject {
	@Getter
	private Bed bed;
	@Getter
	private Room room;
	@Getter
	private Patient patient;
	
	SubjectPatient(){}
	
	
	public void setParameters(Patient patient){
		this.patient = patient;
		this.notifyObservers();
	}
	public void setParameters(Patient patient, Room room, Bed bed){
		this.patient = patient;
		this.room = room;
		this.bed = bed;
		this.notifyObservers();
	}
	
}
