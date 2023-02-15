package com.smile.smile.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smile.smile.models.Patient;
import com.smile.smile.services.PatientService;
import com.smile.smile.services.ProfileService;
import com.smile.smile.services.TreatmentService;

@RestController
@RequestMapping(path = "/api/patients")
public class PatientController {
    private PatientService service;
    private ProfileService profileService;
    private TreatmentService treatmentService;
    
    public PatientController(PatientService service) {
        this.service = service;
    }

    @GetMapping(path = "")
        public List<Patient> getAll() {
            return service.getAll();
    }
    // @GetMapping(path = "/{dni}")
    // public Patient getOne(@PathVariable String dni){
    //     return service.getOne(dni);
    // }
}
