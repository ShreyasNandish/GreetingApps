package com.example.greetingapps.model;

import com.example.greetingapps.DTO.GreetingDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class GreetingData {
    private Long id;
    private String firstName;
    private String lastName;
    private String message;

    public GreetingData(Long id, String firstName, String lastName, String message) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.message = message;
    }

    public GreetingData() {

    }

    public GreetingData(GreetingDTO greetingDTO,String message){
        this.firstName = greetingDTO.getFirstName();
        this.lastName = greetingDTO.getLastName();
        this.message = message;
    }

    public GreetingData(GreetingDTO greetingDTO){
        this.firstName = greetingDTO.getFirstName();
        this.lastName = greetingDTO.getLastName();
    }

    public GreetingData(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }
}
