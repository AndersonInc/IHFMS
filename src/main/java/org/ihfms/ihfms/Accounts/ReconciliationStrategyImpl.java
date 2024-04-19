package org.ihfms.ihfms.Accounts;

import lombok.RequiredArgsConstructor;
import org.ihfms.ihfms.finance.InvoiceRepository;
import org.ihfms.ihfms.finance.models.Invoice;
import org.ihfms.ihfms.finance.models.InvoiceStatus;
import org.ihfms.ihfms.finance.models.Payment;
import org.ihfms.ihfms.finance.repositories.PaymentRepository;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ReconciliationStrategyImpl implements ReconciliationStrategy {
	
	private InvoiceRepository invoiceRepository;
	private PaymentRepository paymentRepository;
	
	@Override
	public void reconcile(Invoice invoice, Payment payment) {
		if (invoice.getAmount().equals(payment.getAmount())) {
			invoice.setStatus(InvoiceStatus.PAID);
			paymentRepository.save(payment);
			invoiceRepository.save(invoice);
		}
	}
}
