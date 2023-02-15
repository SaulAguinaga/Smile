package com.smile.smile.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "profiles")
public class Profile {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_profile")
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastNames;
    @Column(nullable = false)
    private Integer age;
    @Column(nullable = false)
    private Integer telephoneNumber;
    @Column(nullable = false)
    private String direction;
    @Column(nullable = false)
    private String city;
    
    public Profile() {
    }
    public Profile(Long id, String firstName, String lastNames, Integer age, Integer telephoneNumber, String direction,
            String city) {
        this.id = id;
        this.firstName = firstName;
        this.lastNames = lastNames;
        this.age = age;
        this.telephoneNumber = telephoneNumber;
        this.direction = direction;
        this.city = city;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastNames() {
        return lastNames;
    }
    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public Integer getTelephoneNumber() {
        return telephoneNumber;
    }
    public void setTelephoneNumber(Integer telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
    public String getDirection() {
        return direction;
    }
    public void setDirection(String direction) {
        this.direction = direction;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    
}
