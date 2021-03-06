package com.pushbutton.models;

import javax.persistence.*;

@Entity
@Table(name = "source_types")
public class SourceType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    private Integer id;
    private String type;

    private SourceType() {
    }

    private SourceType(Integer id, String type) {
        this.id = id;
        this.type = type;
    }

    public static SourceType of(String type) {
        return new SourceType(null, type);
    }

    public static SourceType of(Integer id) {
        return new SourceType(id, null);
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
