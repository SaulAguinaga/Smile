package com.smile.smile.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smile.smile.models.Profile;
import com.smile.smile.repositories.ProfileRepository;

@Service
public class ProfileService {

    private ProfileRepository repository;
    
    public ProfileService(ProfileRepository repository) {
        this.repository = repository;
    }

    public List<Profile> getAll() {
        return repository.findAll();
    }

    public Profile getOne(Long id) {
        return repository.findById(id).get();
    }
    
}

