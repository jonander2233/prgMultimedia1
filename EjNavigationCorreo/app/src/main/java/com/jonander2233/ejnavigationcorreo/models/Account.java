package com.jonander2233.ejnavigationcorreo.models;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private int id;
    private String name;
    private String firstSurname;
    private String email;
    private List<Contact> contacts;

    public Account(int id, String name, String firstSurname, String email, List<Contact> contacts) {
        this.id = id;
        this.name = name;
        this.firstSurname = firstSurname;
        this.email = email;
        this.contacts = contacts;
    }

    public Account(int id, String name, String firstSurname, String email) {
        this.id = id;
        this.name = name;
        this.firstSurname = firstSurname;
        this.email = email;
        this.contacts = new ArrayList<>();
    }

}
