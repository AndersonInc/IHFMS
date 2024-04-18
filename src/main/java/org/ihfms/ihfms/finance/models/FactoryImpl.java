package org.ihfms.ihfms.finance.models;

public class FactoryImpl implements Factory{
	
	@Override
	public Invoice createInvoice() {
		return new Invoice();
		
	}
	
	@Override
	public Payment createPayment() {
		return new Payment();
	}
}
