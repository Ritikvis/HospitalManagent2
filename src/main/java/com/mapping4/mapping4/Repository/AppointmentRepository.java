package com.mapping4.mapping4.Repository;

import com.mapping4.mapping4.Models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}
