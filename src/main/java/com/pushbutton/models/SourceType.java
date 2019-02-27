package com.pushbutton.models;

import javax.persistence.*;

@Entity
@Table(name = "source_types")
public class SourceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;

    private SourceType() {
    }

    private SourceType(String type) {
        this.type = type;
    }

    public static SourceType of(String type) {
        return new SourceType(type);
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
