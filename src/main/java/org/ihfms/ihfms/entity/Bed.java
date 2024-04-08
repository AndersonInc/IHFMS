package org.ihfms.ihfms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity(name = "beds")
@Data
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
	private Patient inpatient;
	
	
}

