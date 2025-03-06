package com.mapping4.mapping4.Repository;

import com.mapping4.mapping4.Models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long>{
}
