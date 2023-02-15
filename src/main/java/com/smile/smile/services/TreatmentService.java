package com.smile.smile.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smile.smile.models.Treatment;
import com.smile.smile.repositories.TreatmentRepository;

@Service
public class TreatmentService {

    private TreatmentRepository repository;
    
    public TreatmentService(TreatmentRepository repository) {
        this.repository = repository;
    }

    public List<Treatment> getAll() {
        return repository.findAll();
    }

    public Treatment getOne(Long id) {
        return repository.findById(id).get();
    }
    
}
