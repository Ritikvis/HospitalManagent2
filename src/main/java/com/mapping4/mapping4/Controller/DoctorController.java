package com.mapping4.mapping4.Controller;

import com.mapping4.mapping4.Models.Doctor;
import com.mapping4.mapping4.Models.Patient;
import com.mapping4.mapping4.Service.AppointmentService;
import com.mapping4.mapping4.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private AppointmentService appointmentService;
    @PostMapping("CreateDoctor")
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor){

        Doctor doctor1 = doctorService.Create(doctor);
        return new ResponseEntity<>(doctor1, HttpStatus.CREATED);
    }
    @GetMapping("{doctorId}/total-revenue")
    public String TotalRevenueFromDoctor(@PathVariable Long doctorId){
        return appointmentService.TotalRevenueFromDoctor(doctorId);
    }



    @GetMapping("/available-experienced")
    public List<Doctor> getAvailableExperiencedDoctors() {
        return doctorService.getAvailableExperiencedDoctors();
    }



}
