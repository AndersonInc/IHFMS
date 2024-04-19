package org.ihfms.ihfms.Accounts;

import java.util.List;

import org.ihfms.ihfms.finance.models.Invoice;
import org.ihfms.ihfms.finance.models.Payment;

public interface AccountsService {
	public List<Invoice> findAllInvoices();
	public List<Payment> findAllPayments();
	void generateInvoices();
	
}
