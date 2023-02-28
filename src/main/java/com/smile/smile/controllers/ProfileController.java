package com.smile.smile.controllers;

import java.util.List;

import org.springframework.data.repository.config.RepositoryNameSpaceHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    @DeleteMapping(path = "/{id}")
    public List<Profile> delete(@PathVariable Long id){
        return service.delete(id);
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody ProfilePayloads profile){
        Profile profileTemporal = service.getOne(id);
        try {
            if (profileTemporal != null) {
                profile.setId(id);
                service.save(profile);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
