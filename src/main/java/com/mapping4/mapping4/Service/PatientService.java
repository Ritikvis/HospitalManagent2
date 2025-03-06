package com.mapping4.mapping4.Service;

import com.mapping4.mapping4.Models.Patient;
import com.mapping4.mapping4.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;
    public Patient Create(Patient patient) {
        return patientRepository.save(patient);
    }
}
