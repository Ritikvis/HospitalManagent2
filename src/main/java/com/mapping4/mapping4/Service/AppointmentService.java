package com.mapping4.mapping4.Service;

import com.mapping4.mapping4.Models.Appointment;
import com.mapping4.mapping4.Models.Doctor;
import com.mapping4.mapping4.Models.Patient;
import com.mapping4.mapping4.Repository.AppointmentRepository;
import com.mapping4.mapping4.Repository.DoctorRepository;
import com.mapping4.mapping4.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    public Appointment Create(Appointment appointment, Long doctorId, Long patientId) {
        Doctor doctor = doctorRepository.findById(doctorId).
                orElseThrow(()-> new RuntimeException("Id not found" + doctorId));
        Patient patient = patientRepository.findById(patientId).
                orElseThrow(()-> new RuntimeException("Id not found" + patientId));
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        return appointmentRepository.save(appointment);
    }
}
