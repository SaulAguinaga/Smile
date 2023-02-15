package com.smile.smile.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "patients")
public class Patient {
    @Id @Column(name= "dni")
    private String dni;
    @OneToOne
    private Profile profile;
    @ManyToMany
    private List<Treatment> treatment;

    
    public Patient() {
    }


    public Patient(String dni, Profile profile, List<Treatment> treatment) {
        this.dni = dni;
        this.profile = profile;
        this.treatment = treatment;
    }


    public String getDni() {
        return dni;
    }


    public void setDni(String dni) {
        this.dni = dni;
    }


    public Profile getProfile() {
        return profile;
    }


    public void setProfile(Profile profile) {
        this.profile = profile;
    }


    public List<Treatment> getTreatment() {
        return treatment;
    }


    public void setTreatment(List<Treatment> treatment) {
        this.treatment = treatment;
    }


    
    
    
}
