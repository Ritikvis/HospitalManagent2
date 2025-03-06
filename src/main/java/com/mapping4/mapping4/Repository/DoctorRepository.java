package com.mapping4.mapping4.Repository;

import com.mapping4.mapping4.Models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
