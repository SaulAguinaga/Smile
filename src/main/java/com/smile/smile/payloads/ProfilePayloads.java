package com.smile.smile.payloads;

public class ProfilePayloads {
    private Long id;
    private String firstName;
    private String lastNames;
    private Integer age;
    private Integer telephoneNumber;
    private String direction;
    private String city;
    
    
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
    
    
    public ProfilePayloads(Long id, String firstName, String lastNames, Integer age, Integer telephoneNumber,
            String direction, String city) {
        this.id = id;
        this.firstName = firstName;
        this.lastNames = lastNames;
        this.age = age;
        this.telephoneNumber = telephoneNumber;
        this.direction = direction;
        this.city = city;
    }
    
    public ProfilePayloads() {
    }
    

    
    

    
}


