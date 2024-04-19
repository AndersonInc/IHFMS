package org.ihfms.ihfms.Accounts;

import java.util.List;

import lombok.AllArgsConstructor;
import org.ihfms.ihfms.Accounts.decorators.GeneratePDF;
import org.ihfms.ihfms.finance.InvoiceRepository;
import org.ihfms.ihfms.finance.models.Invoice;
import org.ihfms.ihfms.finance.models.Payment;
import org.ihfms.ihfms.finance.repositories.PaymentRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AccountsReconciliationServiceImpl implements AccountsService,AccountsReconciliationService {
	private final InvoiceRepository invoiceRepository;
	private final PaymentRepository paymentRepository;
	private final ReconciliationStrategy reconciliationStrategy;
	private final GeneratePDF generatePDF;
	
	@Override
	public void reconcile(Invoice invoice, Payment payment) {
		reconciliationStrategy.reconcile(invoice, payment);
	}
	
	public void flagDiscrepancy(Invoice invoice, Payment payment) {
		// Logic to flag discrepancies
	}
	
	@Override
	public List<Invoice> findAllInvoices() {
		return invoiceRepository.findAll();
	}
	@Override
	public List<Payment> findAllPayments() {
		return paymentRepository.findAll();
	}
	
	public void generateInvoices(){
		List<Invoice> invoices = invoiceRepository.findAll();
		List<Payment> payments = paymentRepository.findAll();
		generatePDF.generatePDF(invoices,payments);
	}

}
