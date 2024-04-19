package org.ihfms.ihfms.Accounts;

import org.ihfms.ihfms.finance.models.Invoice;
import org.ihfms.ihfms.finance.models.Payment;
import org.springframework.stereotype.Component;


public interface ReconciliationStrategy {
	void reconcile(Invoice invoice, Payment payment);

}
