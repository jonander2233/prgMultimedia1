package com.jonander2233.ejnavigationcorreotutoriail.models;

import java.util.List;

public class Account {
    private final int id;
    private final String name;
    private final String firstSurname;
    private final String email;
    private final List<Contact> contacts;

    public Account(int id, String name, String firstSurname, String email, List<Contact> contacts) {
        this.id = id;
        this.name = name;
        this.firstSurname = firstSurname;
        this.email = email;
        this.contacts = contacts;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public String getEmail() {
        return email;
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}
