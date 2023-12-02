package com.example.appointment.persistance.dao;

import com.example.appointment.persistance.models.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
}
