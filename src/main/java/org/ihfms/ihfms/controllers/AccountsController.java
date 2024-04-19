package org.ihfms.ihfms.controllers;

import lombok.RequiredArgsConstructor;
import org.ihfms.ihfms.Accounts.AccountsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("Accounts reconciliation")
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountsController {
	private final AccountsService accountsService;
	
	@GetMapping("/invoices")
	public void displayInvoices(){
		accountsService.findAllInvoices();
	}
	
	@GetMapping("/payments")
	public void displayPayments(){
		accountsService.findAllPayments();
	}
	
	@GetMapping("/invoicepdf")
	public void viewPDF(){
		accountsService.generateInvoices();
	}

}
