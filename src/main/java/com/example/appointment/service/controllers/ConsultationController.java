package com.example.appointment.service.controllers;

import com.example.appointment.persistance.dao.ConsultationRepository;
import com.example.appointment.persistance.models.Consultation;
import com.example.appointment.service.serviceInterface.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/api/v1/consultations")
public class ConsultationController {
    @Autowired
    ConsultationService consultationService;

    @GetMapping
    public ResponseEntity<List<Consultation>> getAllConsultations(){
        List<Consultation> consultations = consultationService.getAllConsultations();
        return new ResponseEntity<>(consultations, HttpStatus.OK);
    }
    @GetMapping("/{conId}")
    public ResponseEntity<Consultation> getConsultationById(@PathVariable("conId") Long conId){
        Consultation consultation = consultationService.getConsultationById(conId);
        if (consultation != null){
            return new ResponseEntity<>(consultation, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/new")
    public ResponseEntity<Consultation> saveConsultation(@RequestBody Consultation consultation){
        Consultation newCon = consultationService.saveConsultation(consultation);
        return new ResponseEntity<>(newCon, HttpStatus.CREATED);
    }
    @PutMapping("/{conId}/edit")
    public ResponseEntity<Consultation> updateConsultation(@PathVariable("conId") Long conId, @RequestBody Consultation consultation){
        Consultation toUpdateCon = consultationService.getConsultationById(conId);
        if (toUpdateCon != null){
            toUpdateCon.setDateCons(consultation.getDateCons());
            toUpdateCon.setRecapCons(consultation.getRecapCons());
            Consultation newCon = consultationService.saveConsultation(toUpdateCon);
            return new ResponseEntity<>(newCon, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{conId}/delete")
    public ResponseEntity<Long> updateConsultation(@PathVariable("conId") Long conId){
        Consultation toDeleteCon = consultationService.getConsultationById(conId);
        if (toDeleteCon != null){
            consultationService.deleteConsultation(conId);
            return new ResponseEntity<>(conId, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
