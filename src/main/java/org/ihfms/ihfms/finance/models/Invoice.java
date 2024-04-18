package org.ihfms.ihfms.finance.models;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ihfms.ihfms.entity.InPatient;
import org.ihfms.ihfms.entity.OutPatient;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Double amount;
	
	private LocalDate invoiceDate;
	
	@Enumerated(EnumType.STRING)
	private InvoiceStatus status;
	
	@OneToOne(mappedBy = "invoice", cascade = CascadeType.ALL)
	private InPatient inPatient;
	
	@OneToOne(mappedBy = "invoice", cascade = CascadeType.ALL)
	private OutPatient outPatient;
	
	
}
