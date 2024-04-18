package org.ihfms.ihfms.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.ihfms.ihfms.finance.models.Invoice;
import org.ihfms.ihfms.finance.models.Payment;

@RequiredArgsConstructor
@Entity
public class OutPatient extends Patient{
	
	@OneToOne
	@JoinColumn(name = "invoice_id")
	private Invoice invoice;
	
	@OneToOne
	@JoinColumn(name = "payment_id")
	private Payment payment;
	
//	public OutPatient(Patient patient) {
//	}
}
