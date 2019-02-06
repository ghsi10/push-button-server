package com.pushbutton.models;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "phones")
public class Phone {

    @Id
    private String device;
    private String token;

    private Phone() {
    }

    private Phone(String device, String token) {
        this.device = device;
        this.token = token;
    }

    public static Phone of(String device, String token) {
        return new Phone(device, token);
    }

    public String getDevice() {
        return device;
    }

    public String getToken() {
        return token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return device.equals(phone.device) && token.equals(phone.token);
    }

}
