package com.jonander2233.fragmentscontactlist.models;

import java.io.Serializable;
import java.util.Objects;

public class Mail implements Serializable {
    private final String from;
    private final String subject;
    private final String text;

    public Mail(String from, String subject, String text) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mail)) return false;
        Mail mail = (Mail) o;
        return Objects.equals(from, mail.from) && Objects.equals(subject, mail.subject) && Objects.equals(text, mail.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, subject, text);
    }

    @Override
    public String toString() {
        return "Mail{" +
                "from='" + from + '\'' +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
