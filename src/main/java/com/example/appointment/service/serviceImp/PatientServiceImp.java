package com.example.appointment.service.serviceImp;

import com.example.appointment.persistance.dao.PatientRepository;
import com.example.appointment.persistance.models.Patient;
import com.example.appointment.service.serviceInterface.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PatientServiceImp implements PatientService {

    PatientRepository patientRepository;

    @Autowired
    public PatientServiceImp(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        // TODO Auto-generated method stub
        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Patient patient) {
        // TODO Auto-generated method stub
        return patientRepository.saveAndFlush(patient);
    }

    @Override
    public boolean deletePatient(Long id) {
        // TODO Auto-generated method stub
        patientRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Patient> getListPatient() {
        // TODO Auto-generated method stub
        return  patientRepository.findAll();
    }

    @Override
    public Patient getPatient(Long id) {
        // TODO Auto-generated method stub
        return  patientRepository.findById(id).get();
    }

    @Override
    public Patient findPatientByName(String name) {
        // TODO Auto-generated method stub
        return  patientRepository.findByNom(name);
    }

    @Override
    public int getQuantityOfPatient() {
        // TODO Auto-generated method stub
        return  patientRepository.getQuantityOfPatient();
    }

    @Override
    public Patient getPatientByIdPatient(Long id) {
        // TODO Auto-generated method stub
        return null;
    }


}
