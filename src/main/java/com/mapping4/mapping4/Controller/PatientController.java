package com.mapping4.mapping4.Controller;

import com.mapping4.mapping4.Models.Doctor;
import com.mapping4.mapping4.Models.Patient;
import com.mapping4.mapping4.Service.DoctorService;
import com.mapping4.mapping4.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;
    @PostMapping("CreatePatient")
    public ResponseEntity<Patient> createDoctor(@RequestBody Patient patient){

        Patient patient1 = patientService.Create(patient);
        return new ResponseEntity<>(patient1, HttpStatus.CREATED);
    }
}
