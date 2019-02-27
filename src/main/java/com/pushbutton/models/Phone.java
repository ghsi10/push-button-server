package com.pushbutton.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "phones")
public class Phone {

    @Id
    private String phoneNumber;
    @Column(unique = true)
    private String token;
    private String description;

    private Phone() {
    }

    private Phone(String phoneNumber, String token, String description) {
        this.phoneNumber = phoneNumber;
        this.token = token;
        this.description = description;
    }

    public static Phone of(String phoneNumber, String token, String description) {
        return new Phone(phoneNumber, token, description);
    }

    public static Phone of(String phoneNumber, String token) {
        return of(phoneNumber, token, null);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getToken() {
        return token;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
