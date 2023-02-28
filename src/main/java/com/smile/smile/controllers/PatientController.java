package com.smile.smile.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.data.repository.support.Repositories;
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

import com.smile.smile.models.Patient;
import com.smile.smile.payloads.PatientPayloads;
import com.smile.smile.services.PatientService;


@RestController
@RequestMapping(path = "/api/patients")
public class PatientController {
    private PatientService service;

    
    public PatientController(PatientService service) {
        this.service = service;
    }

    @GetMapping(path = "")
        public List<Patient> getAll() {
            return service.getAll();
    }
    @GetMapping(path = "/{dni}")
    public Patient getOne(@PathVariable String dni){
        return service.getOne(dni);
    }
    @PostMapping(path = "")
    public void save(@RequestBody PatientPayloads patient){
        service.save(patient);
    }
    @DeleteMapping(path = "/{dni}")
    public List<Patient> delete(@PathVariable String dni){
        return service.delete(dni);
    }
    @PutMapping(path = "/{dni}")
    public ResponseEntity<Patient> update(@PathVariable String dni, @RequestBody PatientPayloads patient){
        Patient patientTemporal = service.getOne(dni);
        try {
            if (patientTemporal != null) {
                patient.setDni(dni);
                service.save(patient);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
