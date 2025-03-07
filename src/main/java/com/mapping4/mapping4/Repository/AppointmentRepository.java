package com.mapping4.mapping4.Repository;

import com.mapping4.mapping4.Models.Appointment;
import com.mapping4.mapping4.Models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {


}
