package com.mapping4.mapping4.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.ToString;

import java.util.List;


@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    @Column(name = "patient_name",nullable = false)
    private String name;
    @Column(name = "age",nullable = false)
    private String age;
    @Column(name = "mob_num",unique = true,nullable = false)
    private String contact;
    private String address;
    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    private List<Appointment> appointment;
    @OneToOne
    @ToString.Exclude
    private Bill bill;
    public Patient(){};

    public Patient(Long patientId, String name, String age, String contact, String address, List<Appointment> appointment, Bill bill) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.address = address;
        this.appointment = appointment;
        this.bill = bill;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Appointment> getAppointment() {
        return appointment;
    }

    public void setAppointment(List<Appointment> appointment) {
        this.appointment = appointment;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
