package org.ihfms.ihfms.finance.service;

import java.time.LocalDate;

import lombok.RequiredArgsConstructor;
import org.ihfms.ihfms.Accounts.ReconciliationStrategy;
import org.ihfms.ihfms.entity.Patient;
import org.ihfms.ihfms.entity.PatientType;
import org.ihfms.ihfms.finance.models.Factory;
import org.ihfms.ihfms.finance.models.Invoice;
import org.ihfms.ihfms.finance.models.InvoiceStatus;
import org.ihfms.ihfms.finance.models.Payment;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InvoiceServiceImpl implements InvoiceService{
	private final Factory factory;
	private final ReconciliationStrategy reconciliationStrategy;
	
	public void generateInvoice(Patient patient){
		Invoice invoice = factory.createInvoice();
		invoice.setInvoiceDate(LocalDate.now());
		invoice.setStatus(InvoiceStatus.UNPAID);
		if (patient.getPatientType().equals(PatientType.INPATIENT)){
			invoice.setAmount(1000000.0);
			//invoiceRepository.save(invoice);
		}else {
			invoice.setAmount(500000.0);
			//invoiceRepository.save(invoice);
		}
		var payment = generatePayment(patient);
		reconciliationStrategy.reconcile(invoice,payment);
	}
	
	public Payment generatePayment(Patient patient) {
		Payment payment = factory.createPayment();
		payment.setPaymentDate(LocalDate.now());
		
		if (patient.getPatientType().equals(PatientType.INPATIENT)) {
			payment.setAmount(1000000.0);
			//paymentRepository.save(payment);
		} else {
			payment.setAmount(500000.0);
			//paymentRepository.save(payment);
		}
		return payment;
	}
	
}
