package com.mapping4.mapping4.Models;

import com.mapping4.mapping4.Enum.Status;
import jakarta.persistence.*;

import lombok.ToString;

import java.time.LocalDate;
@Entity
@ToString(exclude = {"doctor", "patient", "bill"})
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    private LocalDate date;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL)
    private Bill bill;
    public Appointment(){};

    public Appointment(Long id, Doctor doctor, Patient patient, LocalDate date, Status status, Bill bill) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.status = status;
        this.bill = bill;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
