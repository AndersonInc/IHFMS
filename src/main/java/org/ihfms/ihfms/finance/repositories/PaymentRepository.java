package org.ihfms.ihfms.finance.repositories;

import org.ihfms.ihfms.finance.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {

}
