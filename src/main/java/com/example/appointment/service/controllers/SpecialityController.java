package com.example.appointment.service.controllers;

import com.example.appointment.persistance.dao.SpecialityRepository;
import com.example.appointment.persistance.models.Patient;
import com.example.appointment.persistance.models.Speciality;
import com.example.appointment.service.serviceInterface.SpecialityService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/api/v1/specialities")
public class SpecialityController {
    @Autowired
    SpecialityService specialityService;

    @PostMapping("/new")
    public ResponseEntity<Speciality> createSpeciality(@RequestBody Speciality speciality){
        Speciality newSpecialty = specialityService.saveSpecialty(speciality);
        return new ResponseEntity<>(newSpecialty, HttpStatus.CREATED);
    }

    @GetMapping("/{specialityId}")
    public ResponseEntity<Speciality> findSpecialityById(@PathVariable("specialityId") Long specialityId){
        Speciality speciality = specialityService.findSpecialityById(specialityId);
        return new ResponseEntity<>(speciality, HttpStatus.OK);

    }
    @GetMapping()
    public ResponseEntity<List<Speciality>> getAllSpeciality(){
        List<Speciality> specialities = specialityService.getAllSpecialties();
        return new ResponseEntity<>(specialities, HttpStatus.OK);
    }
    @PutMapping("/{specialityId}/edit")
    public ResponseEntity<Speciality> updateSpeciality(@PathVariable("specialityId") Long specialityId, @RequestBody Speciality speciality){
        Speciality specialityData = specialityService.findSpecialityById(specialityId);

        if (specialityData != null) {
            Speciality _speciality = new Speciality();
            _speciality.setId(specialityId);
            _speciality.setSpecialityName(speciality.getSpecialityName());
            Speciality updatedSpeciality = specialityService.updateSpeciality(_speciality);
            return new ResponseEntity<>(updatedSpeciality, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{specialityId}/delete")
    public ResponseEntity<Long> deletePatient(@PathVariable("specialityId") Long specialityId) {
        specialityService.deletePatient(specialityId);
        return new ResponseEntity<>(specialityId, HttpStatus.OK);
    }
}
