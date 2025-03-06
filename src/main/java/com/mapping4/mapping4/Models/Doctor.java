package com.mapping4.mapping4.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mapping4.mapping4.Enum.Available;
import jakarta.persistence.*;

import lombok.ToString;

import java.util.List;


@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;

    @Column(name = "doctor_name", nullable = false)
    private String name;

    @Column(name = "specialization", nullable = false)
    private String specialization;

    private String experience;

    @Enumerated(EnumType.STRING)  // Add this annotation
    private Available availabilityStatus;
    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    private List<Appointment> appointment;
    public Doctor(){};

    public Doctor(Long doctorId, String name, String specialization, String experience, Available availabilityStatus, List<Appointment> appointment) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.experience = experience;
        this.availabilityStatus = availabilityStatus;
        this.appointment = appointment;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public Available getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(Available availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public List<Appointment> getAppointment() {
        return appointment;
    }

    public void setAppointment(List<Appointment> appointment) {
        this.appointment = appointment;
    }
}
