package com.example.appointment.persistance.dao;

import com.example.appointment.persistance.models.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
    Speciality findBySpecialityName(String specialityName);

}
