package com.example.appointment.service.serviceInterface;

import com.example.appointment.persistance.models.Patient;

import java.util.List;

public interface PatientService {

    Patient savePatient(Patient patient);
    Patient updatePatient(Patient patient);
    boolean deletePatient(Long id);
    List<Patient> getListPatient();
    Patient getPatient(Long id);
    Patient findPatientByName(String name);
    int getQuantityOfPatient();
    Patient getPatientByIdPatient(Long id);


}
