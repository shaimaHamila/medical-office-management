package com.example.appointment.service.controllers;

import com.example.appointment.persistance.models.Patient;
import com.example.appointment.service.serviceInterface.PatientService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PatientController {
    PatientService patientService;
    @Autowired
    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @PostMapping()
    Patient save(@RequestBody Patient patient) {
        System.out.printf("*******save ***********", patient);
        Patient p=patientService.savePatient(patient);
        System.out.println("*******"+p.getEmail());
        return p ;
    }

    @GetMapping("/{id}")
    Patient getPatientById(@PathVariable Long id) {
        return patientService.getPatient(id);
    }

    @GetMapping("/quantity")
    int getQuantityPatient() {
        return patientService.getQuantityOfPatient();
    }

    @GetMapping("/patientByName/{name}")
    Patient getPatientByName(@PathVariable String name) {
        return patientService.findPatientByName(name);
    }

    @DeleteMapping("/delete/{id}")
    boolean delete(@PathVariable Long id) {
        patientService.deletePatient(id);
        return true;
    }

}
