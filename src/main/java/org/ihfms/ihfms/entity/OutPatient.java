package org.ihfms.ihfms.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Entity
public class OutPatient extends Patient{
	
	public OutPatient(String firstName, String lastName, String email,
			String phoneNum, String phoneNum1, LocalDate admissionDate,
			int age, Gender gender) {
	}
	
	public OutPatient(Patient patient) {
	}
}
