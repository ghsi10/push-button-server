package com.pushbutton.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "source_devices")
public class SourceDevice {
    @Id
    private Long id;
    @ManyToOne
    private SourceType sourceType;
    @ManyToOne
    private Message message;
    @ManyToMany
    @JoinTable(name ="source_to_mobile")
    private Set<Phone> phones;

    private SourceDevice() {
    }

    private SourceDevice(Long id, SourceType sourceType, Message message) {
        this.id = id;
        sourceType = sourceType;
        this.message = message;
    }

    public static SourceDevice of(Long id, SourceType sourceType, Message message) {
        return new SourceDevice(id, sourceType, message);
    }

    public static SourceDevice of(Long id, SourceType sourceType) {
        return of(id, sourceType, null);
    }

    public static SourceDevice of(Long id, Message message) {
        return of(id, null, message);
    }

    public Long getId() {
        return id;
    }

    public SourceType getSourceType() {
        return sourceType;
    }

    public Message getMessage() {
        return message;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public void addPhone(Phone phone) {
        phones.add(phone);
    }


    public void removePhone(Phone phone) {
        phones.remove(phone);
    }
}
