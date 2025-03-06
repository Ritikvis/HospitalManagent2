package com.mapping4.mapping4.Service;

import com.mapping4.mapping4.Models.Doctor;
import com.mapping4.mapping4.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
    public Doctor Create(Doctor doctor) {

        return doctorRepository.save(doctor);

    }
}
