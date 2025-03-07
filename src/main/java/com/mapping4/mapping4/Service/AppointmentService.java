package com.mapping4.mapping4.Service;

import com.mapping4.mapping4.Models.Appointment;
import com.mapping4.mapping4.Models.Doctor;
import com.mapping4.mapping4.Models.Patient;
import com.mapping4.mapping4.Repository.AppointmentRepository;
import com.mapping4.mapping4.Repository.DoctorRepository;
import com.mapping4.mapping4.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public String TotalRevenueFromDoctor(Long doctorId) {
        int totalAmount = 0;
        Doctor doctor = doctorRepository.findById(doctorId).
                orElseThrow(()-> new RuntimeException("Id not found" + doctorId));
        for(Appointment appointment:appointmentRepository.findAll()){
            if(appointment.getDoctor() == doctor){
                totalAmount += Integer.parseInt(appointment.getPatient().getBill().getTotalAmount());
            }
        }
        return String.valueOf(totalAmount);
    }

    public List<String> getPatientsWithUpcomingAppointments() {
        LocalDate today = LocalDate.now();
        LocalDate nextWeek = today.plusDays(7);
        List<String> patients = new ArrayList<>();

        for (Appointment appointment : appointmentRepository.findAll()) {
            LocalDate appointmentDate = appointment.getDate();
            if ((appointmentDate.isEqual(today) || appointmentDate.isAfter(today))
                    && appointmentDate.isBefore(nextWeek.plusDays(1))) { // Includes the 7th day

                patients.add(appointment.getPatient().getName()); // Add patient from the appointment
            }
        }
        return patients;
    }

    public Patient getTopPatient(Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor ID not found: " + doctorId));

        Map<Patient, Integer> patientCountMap = new HashMap<>();
        int maxCount = 0;
        Patient topPatient = null;

        for (Appointment appointment : appointmentRepository.findAll()) {
            if(appointment.getDoctor() == doctor){
                Patient patient = appointment.getPatient();
                patientCountMap.put(patient, patientCountMap.getOrDefault(patient, 0) + 1);

                if (patientCountMap.get(patient) > maxCount) {
                    maxCount = patientCountMap.get(patient);
                    topPatient = patient;
                }
            }
        }
        return topPatient;
    }
}
