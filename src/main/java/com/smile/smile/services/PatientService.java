package com.smile.smile.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smile.smile.models.Patient;
import com.smile.smile.payloads.PatientPayloads;
import com.smile.smile.repositories.PatientRepository;
import com.smile.smile.repositories.ProfileRepository;
import com.smile.smile.repositories.TreatmentRepository;

@Service
public class PatientService {
    private PatientRepository repository;

    public PatientService(PatientRepository repository, ProfileRepository profileRepository,
            TreatmentRepository treatmentRepository) {
        this.repository = repository;
    }

    public List<Patient> getAll() {
        return repository.findAll();
    }

    public Patient getOne(String dni) {
        return repository.findByDni(dni);
    }

    public void save(PatientPayloads patient) {
        Patient patientToAdd = new Patient(patient.getDni(), null, null);
        repository.save(patientToAdd);
    }
    
}
