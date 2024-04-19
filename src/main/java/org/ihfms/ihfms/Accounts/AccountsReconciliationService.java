package org.ihfms.ihfms.Accounts;

import org.ihfms.ihfms.finance.models.Invoice;
import org.ihfms.ihfms.finance.models.Payment;

public interface AccountsReconciliationService {
	void reconcile(Invoice invoice, Payment payment);

}
