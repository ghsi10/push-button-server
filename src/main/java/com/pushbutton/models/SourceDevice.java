package com.pushbutton.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "source_devices")
public class SourceDevice {
    @Id
    private String id;
    private String description;
    @ManyToOne
    private SourceType sourceType;
    @ManyToOne
    private Message message;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "source_to_mobile")
    private Set<Phone> phones;

    private SourceDevice() {
    }

    private SourceDevice(String id, SourceType sourceType, Message message, String description) {
        this.id = id;
        sourceType = sourceType;
        this.message = message;
        this.description = description;
    }

    public static SourceDevice of(String id, SourceType sourceType, Message message) {
        return new SourceDevice(id, sourceType, message, null);
    }

    public static SourceDevice of(String id, SourceType sourceType, Message message, String description) {
        return new SourceDevice(id, sourceType, message, description);
    }

    public static SourceDevice of(String id, SourceType sourceType) {
        return of(id, sourceType, null);
    }

    public static SourceDevice of(String id, Message message) {
        return of(id, null, message);
    }

    public String getId() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
