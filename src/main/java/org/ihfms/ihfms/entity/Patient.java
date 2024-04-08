package org.ihfms.ihfms.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity(name = "patients")
@Builder
@Data
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public  class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer iD;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNum;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private int age;
	private LocalDate admissionDate;
	@Enumerated(EnumType.STRING)
	private PatientType patientType;
	
	private String roomNumber;
	
	@OneToOne
	@JoinColumn(name = "bed_id")
	private Bed bed;
	
	public Patient() {
	
	}
	
	//	public Patient(String firstName, String lastName, String email, String phoneNum,
//			String phoneNum1, LocalDate admissionDate, int age, Gender gender) {
//	}
}
