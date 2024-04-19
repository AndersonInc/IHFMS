package org.ihfms.ihfms.Accounts.decorators;

import java.util.List;

import org.ihfms.ihfms.finance.models.Invoice;
import org.ihfms.ihfms.finance.models.Payment;

public interface GeneratePDF {
	void generatePDF(List<Invoice> invoices,List<Payment> payments);
	
}
