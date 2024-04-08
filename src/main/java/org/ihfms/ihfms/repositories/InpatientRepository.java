package org.ihfms.ihfms.repositories;

import org.ihfms.ihfms.entity.InPatient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InpatientRepository extends JpaRepository<InPatient, Long> {

}
