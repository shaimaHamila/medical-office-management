package com.example.appointment.service.controllers;
import com.example.appointment.persistance.models.Patient;
import com.example.appointment.service.serviceInterface.PatientService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "http://localhost:8082")
@Controller
@RequestMapping(path = "/api/v1/patients")
public class PatientController {
    PatientService patientService;
    @Autowired
    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @PostMapping("/new")
    public ResponseEntity<Patient> savePatient(@RequestBody Patient patient) {
        log.info("Patient {}",patient);
        Patient newPatient =patientService.savePatient(patient);
        return new ResponseEntity<>(newPatient, HttpStatus.CREATED);
    }

    @PutMapping("/{patientId}/edit")
    public ResponseEntity<Patient> updatePatient(@PathVariable("patientId") Long patientId,@RequestBody Patient patient){
        Patient patientData = patientService.getPatient(patientId);

        if (patientData != null) {
            Patient _patient = new Patient();
            _patient.setId(patientId);
            _patient.setNom(patient.getNom());
            _patient.setEmail(patient.getEmail());

            Patient updatedPatient = patientService.updatePatient(_patient);
            return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    public ResponseEntity<List<Patient>> getAllPatient(){
        List<Patient> patients = patientService.getListPatient();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("patientId") Long patientId) {
        Patient patient = patientService.getPatient(patientId);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @GetMapping("/quantity")
    public ResponseEntity<Integer> getQuantityPatient() {
        Integer quantity =  patientService.getQuantityOfPatient();
        return new ResponseEntity<>(quantity, HttpStatus.OK);
    }

    @GetMapping("/name/{patientName}")
    public ResponseEntity<Patient> getPatientByName(@PathVariable("patientName") String name) {
        Patient patient = patientService.findPatientByName(name);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("{patientId}/delete")
    public ResponseEntity<Long> deletePatient(@PathVariable("patientId") Long patientId) {
        patientService.deletePatient(patientId);
        return new ResponseEntity<>(patientId, HttpStatus.OK);
    }

}
