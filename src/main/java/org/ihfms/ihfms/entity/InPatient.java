package org.ihfms.ihfms.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class InPatient extends Patient{
	private String roomNumber;
	
	@OneToOne
	@JoinColumn(name = "bed_id")
	private Bed bed;
	
//	public InPatient(String firstName, String lastName, String email,
//			String phoneNum, String phoneNum1, LocalDate admissionDate,
//			int age, Gender gender) {
//	}
}
