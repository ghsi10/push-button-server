package com.pushbutton.models;

import javax.persistence.*;

@Entity
@Table(name = "buttons")
public class Button {
    @Id
    private Long id;
    private String message;
    @OneToOne
    private Phone phone;

    private Button() {
    }

    private Button(Long id, String message, Phone phone) {
        this.id = id;
        this.message = message;
        this.phone = phone;
    }

    public static Button of(Long id, String message, Phone phone) {
        return new Button(id, message, phone);
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Phone getPhone() {
        return phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Button button = (Button) o;
        return id.equals(button.id) && message.equals(button.message) && phone.equals(button.phone);
    }
}
