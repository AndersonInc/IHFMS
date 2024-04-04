package org.ihfms.ihfms.repositories;

import org.ihfms.ihfms.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Integer> {

}
