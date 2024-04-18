package org.ihfms.ihfms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.ihfms.ihfms.finance.models.Invoice;
import org.ihfms.ihfms.finance.models.Payment;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class InPatient extends Patient{
	private String roomNumber;
	
	@OneToOne
	@JoinColumn(name = "bed_id")
	private Bed bed;
	
	@OneToOne
	@JoinColumn(name = "invoice_id")
	private Invoice invoice;
	
	@OneToOne
	@JoinColumn(name = "payment_id")
	private Payment payment;

}
