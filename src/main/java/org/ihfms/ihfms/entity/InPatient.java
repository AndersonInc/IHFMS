package org.ihfms.ihfms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
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

}
