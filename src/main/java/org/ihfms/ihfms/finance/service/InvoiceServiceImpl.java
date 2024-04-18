package org.ihfms.ihfms.finance.service;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.ihfms.ihfms.entity.Patient;
import org.ihfms.ihfms.entity.PatientType;
import org.ihfms.ihfms.finance.InvoiceRepository;
import org.ihfms.ihfms.finance.models.Factory;
import org.ihfms.ihfms.finance.models.Invoice;
import org.ihfms.ihfms.finance.models.InvoiceStatus;
import org.ihfms.ihfms.finance.models.Payment;
import org.ihfms.ihfms.finance.repositories.PaymentRepository;

@AllArgsConstructor
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService{
	private final InvoiceRepository invoiceRepository;
	private final PaymentRepository paymentRepository;
	private final Factory factory;
	
	public void generateInvoice(Patient patient){
		Invoice invoice = factory.createInvoice();
		invoice.setInvoiceDate(LocalDate.now());
		invoice.setStatus(InvoiceStatus.UNPAID);
		if (patient.getPatientType().equals(PatientType.INPATIENT)){
			invoice.setAmount(1000000.0);
			invoiceRepository.save(invoice);
		}else {
			invoice.setAmount(500000.0);
			invoiceRepository.save(invoice);
		}
		generatePayment(patient);
		
	}
	
	public void generatePayment(Patient patient) {
		Payment payment = factory.createPayment();
		payment.setPaymentDate(LocalDate.now());
		
		if (patient.getPatientType().equals(PatientType.INPATIENT)) {
			payment.setAmount(1000000.0);
			paymentRepository.save(payment);
		} else {
			payment.setAmount(500000.0);
			paymentRepository.save(payment);
		}
	}
	
}
