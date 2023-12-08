package com.example.appointment.service.controllers;

import com.example.appointment.persistance.models.Medecin;
import com.example.appointment.persistance.models.Patient;
import com.example.appointment.persistance.models.Speciality;
import com.example.appointment.service.serviceInterface.MedecinService;
import com.example.appointment.service.serviceInterface.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/api/v1/medecins")
public class MedecinController {
    @Autowired
    private MedecinService medecinService;
    @Autowired
    private SpecialityService specialityService;
    // Create (POST) a Medecin
    @PostMapping("/new")
    public ResponseEntity<Medecin> createMedecin(@RequestBody Medecin medecin) {
        String specialityName = medecin.getSpeciality().getSpecialityName();
        Speciality speciality = specialityService.findSpecialityByName(specialityName);
        if(speciality == null){
            Speciality newSpeciality = new Speciality();
            newSpeciality.setSpecialityName(specialityName);
            Speciality _specialty = specialityService.saveSpecialty(newSpeciality);
            medecin.setSpeciality(_specialty);
            Medecin createdMedecin = medecinService.saveMedecin(medecin);
            return new ResponseEntity<>(createdMedecin, HttpStatus.CREATED);
        }else{
            medecin.setSpeciality(speciality);
            Medecin createdMedecin = medecinService.saveMedecin(medecin);
            return new ResponseEntity<>(createdMedecin, HttpStatus.CREATED);
        }
    }
    @GetMapping
    public ResponseEntity<List<Medecin>> getAllMedecins(){
        List<Medecin> medecins = medecinService.getAllMedecins();
        return new ResponseEntity<>(medecins, HttpStatus.OK);
    }

    @PutMapping("/{medecinId}/edit")
    public ResponseEntity<Medecin> updateMedecin(@PathVariable("medecinId" )Long medecinId, @RequestBody Medecin medecin){
        Medecin toUpdateMedecin = medecinService.findMedecinById(medecinId);
        if (toUpdateMedecin != null){
            // Update properties of the existing Medecin with values from the updatedMedecin
            toUpdateMedecin.setNom(medecin.getNom());
            toUpdateMedecin.setEmail(medecin.getEmail());
            toUpdateMedecin.setSpeciality(medecin.getSpeciality());
            // Save the updated Medecin entity
            Medecin updatedEntity = medecinService.saveMedecin(toUpdateMedecin);

            return new ResponseEntity<>(updatedEntity,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{medecinId}/delete")
    public ResponseEntity<Long> deleteMedecin(@PathVariable("medecinId" )Long medecinId){
        Medecin toUpdateMedecin = medecinService.findMedecinById(medecinId);
        if (toUpdateMedecin != null){
            medecinService.deleteMedecin(medecinId);
            return new ResponseEntity<>(medecinId,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
