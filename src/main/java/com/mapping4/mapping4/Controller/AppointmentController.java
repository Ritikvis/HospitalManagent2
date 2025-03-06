package com.mapping4.mapping4.Controller;

import com.mapping4.mapping4.Models.Appointment;
import com.mapping4.mapping4.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @PostMapping("createAppointment")
    public ResponseEntity<Appointment> addAppointment(@RequestBody Appointment appointment,
                                                      @RequestParam Long doctorId,@RequestParam
                                                      Long patientId){
        Appointment appointment1 = appointmentService.Create(appointment,doctorId,patientId);
        return new ResponseEntity<>(appointment1, HttpStatus.CREATED);
    }
}
