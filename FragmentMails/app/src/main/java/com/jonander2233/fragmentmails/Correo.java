package com.jonander2233.fragmentmails;

import java.io.Serializable;

public class Correo implements Serializable {
    private final String from;
    private final String subject;
    private final String text;

    public Correo(String from, String subject, String text) {
        this.from = from;
        this.subject = subject;
        this.text = text;
    }
    public String getFrom() {
        return from;
    }
    public String getSubject() {
        return subject;
    }
    public String getText() {
        return text;
    }

}
