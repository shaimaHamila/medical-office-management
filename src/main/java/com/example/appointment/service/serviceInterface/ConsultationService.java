package com.example.appointment.service.serviceInterface;

import com.example.appointment.persistance.models.Consultation;

import java.util.List;

public interface ConsultationService {
    Consultation saveConsultation(Consultation consultation);

    Consultation getConsultationById(Long conId);

    void deleteConsultation(Long conId);

    List<Consultation> getAllConsultations();
}
