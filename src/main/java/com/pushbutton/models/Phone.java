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

    private Phone() {
    }

    private Phone(String phoneNumber, String token) {
        this.phoneNumber = phoneNumber;
        this.token = token;
    }

    public static Phone of(String phoneNumber, String token) {
        return new Phone(phoneNumber, token);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getToken() {
        return token;
    }

}
