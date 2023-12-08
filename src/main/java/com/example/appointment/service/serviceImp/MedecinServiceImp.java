package com.example.appointment.service.serviceImp;

import com.example.appointment.persistance.dao.MedecinRepository;
import com.example.appointment.persistance.models.Medecin;
import com.example.appointment.service.serviceInterface.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedecinServiceImp implements MedecinService {

    @Autowired
    MedecinRepository medecinRepository;

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public List<Medecin> getAllMedecins() {
        return medecinRepository.findAll();
    }

    @Override
    public Medecin findMedecinById(Long medecinId) {
        return medecinRepository.findById(medecinId).get();
    }

    @Override
    public void deleteMedecin(Long medecinId) {
        medecinRepository.deleteById(medecinId);
    }
}
