package com.example.appointment.service.serviceInterface;

import com.example.appointment.persistance.models.Medecin;

import java.util.List;

public interface MedecinService {
    Medecin saveMedecin(Medecin medecin);

    List<Medecin> getAllMedecins();

    Medecin findMedecinById(Long medecinId);

    void deleteMedecin(Long medecinId);
}
