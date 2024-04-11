package org.ihfms.ihfms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity(name = "beds")
@Getter
@Setter
@RequiredArgsConstructor
public class Bed {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String bedNumber;
	
	private boolean occupied;
	
	@ManyToOne
	@JoinColumn(name = "room_id")
	private Room room;
	
	@OneToOne(mappedBy = "bed")
	private InPatient inpatient;
	
	
}

