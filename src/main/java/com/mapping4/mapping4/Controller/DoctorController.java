package com.mapping4.mapping4.Controller;

import com.mapping4.mapping4.Models.Doctor;
import com.mapping4.mapping4.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @PostMapping("CreateDoctor")
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor){

        Doctor doctor1 = doctorService.Create(doctor);
        return new ResponseEntity<>(doctor1, HttpStatus.CREATED);
    }
}
