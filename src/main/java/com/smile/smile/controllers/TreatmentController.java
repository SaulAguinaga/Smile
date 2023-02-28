package com.smile.smile.controllers;

import java.util.List;

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

import com.smile.smile.models.Treatment;
import com.smile.smile.payloads.TreatmentPayload;
import com.smile.smile.services.TreatmentService;

@RestController
@RequestMapping(path = "/api/treatments")
public class TreatmentController {

    private TreatmentService service;

    public TreatmentController(TreatmentService service) {
        this.service = service;
    }

    @GetMapping(path = "")
    public List<Treatment> getAll(){
        return service.getAll();
    }
    @GetMapping(path = "/{id}")
    public Treatment getOne(@PathVariable Long id){
        return service.getOne(id);
    }
    @PostMapping(path = "")
    public void save(@RequestBody TreatmentPayload treatment){
        service.save(treatment);
    }
    @DeleteMapping(path = "/{id}")
    public List<Treatment> delete(@PathVariable Long id){
        return service.delete(id);
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<Treatment> update(@PathVariable Long id, @RequestBody TreatmentPayload treatment){
        Treatment treatmentTemporal = service.getOne(id);
        try {
            if(treatmentTemporal != null){
                treatment.setId(id);
                service.save(treatment);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
