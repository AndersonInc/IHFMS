package org.ihfms.ihfms.controllers.dtos;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ihfms.ihfms.entity.Gender;
import org.ihfms.ihfms.entity.PatientType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientRequest {
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

}
