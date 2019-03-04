package com.pushbutton.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "phones")
public class Phone {

    @Id
    private String token;
    @Column
    private String phoneNumber;
    @Column
    private String deviceName;

    private Phone() {
    }

    private Phone(String phoneNumber, String token, String deviceName) {
        this.phoneNumber = phoneNumber;
        this.token = token;
        this.deviceName = deviceName;
    }

    public static Phone of(String phoneNumber, String token, String deviceName) {
        return new Phone(phoneNumber, token,deviceName);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getToken() {
        return token;
    }

    public String getDeviceName() {
        return deviceName;
    }

}
