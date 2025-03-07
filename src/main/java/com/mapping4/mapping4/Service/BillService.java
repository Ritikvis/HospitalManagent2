package com.mapping4.mapping4.Service;

import com.mapping4.mapping4.Enum.BillStatus;
import com.mapping4.mapping4.Models.Appointment;
import com.mapping4.mapping4.Models.Bill;
import com.mapping4.mapping4.Models.Patient;
import com.mapping4.mapping4.Repository.AppointmentRepository;
import com.mapping4.mapping4.Repository.BillRepository;
import com.mapping4.mapping4.Repository.PatientRepository;
import io.swagger.v3.oas.annotations.servers.ServerVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private PatientRepository patientRepository;
    public Bill Create(Bill bill, Long id, Long patientId) {
        Appointment appointment = appointmentRepository.findById(id).
                orElseThrow(()-> new RuntimeException("Id not found" + id));
        Patient patient = patientRepository.findById(patientId).
                orElseThrow(()-> new RuntimeException("Id not found" + patientId));
        bill.setAppointment(appointment);
        bill.setPatient(patient);
        return billRepository.save(bill);
    }

    public String BillPaid() {
        int total =0;
        for(Bill bill:billRepository.findAll()){
            if(bill.getBillStatus().equals(BillStatus.PAID)){
                total += Integer.parseInt(bill.getTotalAmount());
            }
        }
        return String.valueOf(total);
    }
}
