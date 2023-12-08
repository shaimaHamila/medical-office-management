package com.example.appointment.service.serviceImp;

import com.example.appointment.persistance.dao.SpecialityRepository;
import com.example.appointment.persistance.models.Speciality;
import com.example.appointment.service.serviceInterface.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialityServiceImp implements SpecialityService {

    @Autowired
    SpecialityRepository specialityRepository;

    @Override
    public Speciality saveSpecialty(Speciality speciality) {
        return specialityRepository.save(speciality);
    }

    @Override
    public void deletePatient(Long specialityId) {
        specialityRepository.deleteById(specialityId);
    }

    @Override
    public Speciality updateSpeciality(Speciality speciality) {
        return specialityRepository.save(speciality);
    }

    @Override
    public Speciality findSpecialityById(Long specialityId) {
        return specialityRepository.findById(specialityId).get();
    }

    @Override
    public List<Speciality> getAllSpecialties() {
        return specialityRepository.findAll();
    }

    @Override
    public Speciality findSpecialityByName(String specialityName) {
        return specialityRepository.findBySpecialityName(specialityName);
    }
}
