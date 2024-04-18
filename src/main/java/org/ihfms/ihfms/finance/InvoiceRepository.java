package org.ihfms.ihfms.finance;

import org.ihfms.ihfms.finance.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Long> {

}
