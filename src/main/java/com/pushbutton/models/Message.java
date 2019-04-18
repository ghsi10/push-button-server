package com.pushbutton.models;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    private Integer id;
    private String content;
    private Boolean audio;

    private Message() {
    }

    private Message(String content, Boolean audio) {
        this.content = content;
        this.audio = audio;
    }

    public static Message of(String content, Boolean audio) {
        return new Message(content, audio);
    }

    public static Message of(String content) {
        return new Message(content, false);
    }

    public Integer getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Boolean getAudio() {
        return audio;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAudio(Boolean audio) {
        this.audio = audio;
    }
}
