package com.jonander2233.ejnavigationcorreotutoriail.models;

public class Mail {
    private String from;
    private String to;
    private String subject;
    private String body;
    private String sentOn;
    private boolean readed;
    private boolean deleted;
    private boolean spam;

    public Mail(String from, String to, String subject, String body, String sentOn, boolean readed, boolean deleted, boolean spam) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.body = body;
        this.sentOn = sentOn;
        this.readed = readed;
        this.deleted = deleted;
        this.spam = spam;
    }
}
