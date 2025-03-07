package com.mapping4.mapping4.Controller;

import com.mapping4.mapping4.Models.Appointment;
import com.mapping4.mapping4.Models.Bill;
import com.mapping4.mapping4.Service.AppointmentService;
import com.mapping4.mapping4.Service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BillController {
    @Autowired
    private BillService billService;
    @PostMapping("createBill")
    public ResponseEntity<Bill> addAppointment(@RequestBody Bill bill,
                                               @RequestParam Long id, @RequestParam
                                                      Long patientId){
        Bill bill1 = billService.Create(bill,id,patientId);
        return new ResponseEntity<>(bill1, HttpStatus.CREATED);
    }
    @GetMapping("billPaid/total-revenue")
    public String BillPaid(){
        return billService.BillPaid();
    }
}
