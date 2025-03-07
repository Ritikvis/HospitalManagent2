package com.mapping4.mapping4.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mapping4.mapping4.Enum.BillStatus;
import jakarta.persistence.*;

import lombok.ToString;

@Entity
@ToString(exclude = "appointment")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "appointment_id", unique = true)
    @JsonIgnore
    private Appointment appointment;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    private String totalAmount;

    @Enumerated(value = EnumType.STRING)
    private BillStatus billStatus;
    public Bill(){};

    public Bill(Long id, Appointment appointment, Patient patient, String totalAmount, BillStatus billStatus) {
        this.id = id;
        this.appointment = appointment;
        this.patient = patient;
        this.totalAmount = totalAmount;
        this.billStatus = billStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }
}
