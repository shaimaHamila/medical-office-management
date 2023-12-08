package com.example.appointment.service.serviceImp;

import com.example.appointment.persistance.dao.ConsultationRepository;
import com.example.appointment.persistance.models.Consultation;
import com.example.appointment.service.serviceInterface.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationServiceImp implements ConsultationService {

    @Autowired
    ConsultationRepository consultationRepository;

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @Override
    public Consultation getConsultationById(Long conId) {
        return consultationRepository.findById(conId).get();
    }

    @Override
    public void deleteConsultation(Long conId) {
        consultationRepository.deleteById(conId);
    }

    @Override
    public List<Consultation> getAllConsultations() {
        return consultationRepository.findAll();
    }
}
