package com.smile.smile.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smile.smile.models.Profile;
import com.smile.smile.payloads.ProfilePayloads;
import com.smile.smile.services.ProfileService;

@RestController
@RequestMapping(path = "/api/profiles")
public class ProfileController {
    private ProfileService service;

    public ProfileController(ProfileService service) {
        this.service = service;
    }

    @GetMapping(path = "")
    public List<Profile> getAll(){
        return service.getAll();
    }
    @GetMapping(path = "/{id}")
    public Profile getOne(@PathVariable Long id){
        return service.getOne(id);
    }
    @PostMapping(path = "")
    public void save(@RequestBody ProfilePayloads profile){
        service.save(profile);
    }
    
}
