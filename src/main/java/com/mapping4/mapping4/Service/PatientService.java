package com.mapping4.mapping4.Service;

import com.mapping4.mapping4.Models.Bill;
import com.mapping4.mapping4.Models.Patient;
import com.mapping4.mapping4.Repository.BillRepository;
import com.mapping4.mapping4.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private BillRepository billRepository;

    public Patient Create(Patient patient, Long id) {
        Bill bill = billRepository.findById(id).
                orElseThrow(()-> new RuntimeException("Id not found" + id));
        patient.setBill(bill);
        return patientRepository.save(patient);
    }
}
