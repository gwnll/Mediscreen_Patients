package com.mediscreen.patients.service;

import com.mediscreen.patients.model.Patient;
import com.mediscreen.patients.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Optional<Patient> getPatientById(int id) {
        return patientRepository.findById(id);
    }

    public Iterable<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public void deletePatientById(int id) {
        patientRepository.deleteById(id);
    }

    public void updatePatient(Patient patient) {
        patientRepository.save(patient);
    }

}
