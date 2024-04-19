package org.ihfms.ihfms.Accounts.decorators;

import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.ihfms.ihfms.finance.models.Invoice;
import org.ihfms.ihfms.finance.models.Payment;

public class GeneratePDFImpl implements GeneratePDF{
	
	@Override
	public void generatePDF(List<Invoice> invoices, List<Payment> payments) {
		try {
			PDDocument document = new PDDocument();
			PDPage page = new PDPage();
			document.addPage(page);
			PDPageContentStream contentStream = new PDPageContentStream(document, page);
			
			
			contentStream.setFont(PDType1Font.HELVETICA, 12);
			contentStream.beginText();
			contentStream.newLineAtOffset(100, 700);
			contentStream.showText("Reconciliation Report");
			contentStream.newLine();
			contentStream.showText("=========================");
			contentStream.newLine();
			contentStream.showText("Invoices:");
			contentStream.newLine();
			for (Invoice invoice : invoices) {
				contentStream.showText(invoice.toString());
				contentStream.newLine();
			}
			contentStream.showText("Payments:");
			contentStream.newLine();
			for (Payment payment : payments) {
				contentStream.showText(payment.toString());
				contentStream.newLine();
			}
			contentStream.endText();
			contentStream.close();
			
			// Save the document
			document.save("Reconciliation_Report.pdf");
			document.close();
			
			System.out.println("PDF report generated successfully.");
			
		} catch (IOException e) {
			System.err.println("Error generating PDF report: " + e.getMessage());
		}
		
	}
	
	/**
	 *
	 * @param invoices
	 
	public void generateInvoicePDF(List<Invoice> invoices){
		try {
			PDDocument document = new PDDocument();
			PDPage page = new PDPage();
			document.addPage(page);
			PDPageContentStream contentStream = new PDPageContentStream(document, page);
			
			
			contentStream.setFont(PDType1Font.HELVETICA, 12);
			contentStream.beginText();
			contentStream.newLineAtOffset(100, 700);
			contentStream.showText("Reconciliation Report");
			contentStream.newLine();
			contentStream.showText("=========================");
			contentStream.newLine();
			contentStream.showText("Invoices:");
			contentStream.newLine();
			for (Invoice invoice : invoices) {
				contentStream.showText(invoice.toString());
				contentStream.newLine();
			}
		}catch (Exception e) {
			throw new IllegalStateException("Failed to generate PDF: "+e.getMessage());}
	
	}
	 */
	 
	
	
}
