package com.mapping4.mapping4.Service;

import com.mapping4.mapping4.Models.Doctor;
import com.mapping4.mapping4.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
    public Doctor Create(Doctor doctor) {

        return doctorRepository.save(doctor);

    }
    public List<Doctor> getAvailableExperiencedDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        for(Doctor doctor:doctorRepository.findAll()){
            if(Integer.parseInt(doctor.getExperience()) >= 5){
                doctors.add(doctor);
            }
        }
        return doctors;
    }
}
