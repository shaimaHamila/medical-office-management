package com.example.appointment.service.serviceInterface;

import com.example.appointment.persistance.models.Speciality;

import java.util.List;

public interface SpecialityService {
    Speciality saveSpecialty(Speciality speciality);

    void deletePatient(Long specialityId);

    Speciality updateSpeciality(Speciality speciality);

    Speciality findSpecialityById(Long specialityId);

    List<Speciality> getAllSpecialties();

    Speciality findSpecialityByName(String specialityName);
}
