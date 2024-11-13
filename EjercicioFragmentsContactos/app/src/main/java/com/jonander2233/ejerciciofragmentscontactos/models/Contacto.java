package com.jonander2233.ejerciciofragmentscontactos.models;

import java.util.Date;

public class Contacto {
    private int id;
    private String name;
    private String firstSurname;
    private String secondSurname;
    private int photo;
    private Date birth;
    private String company;
    private String email;
    private String phone1;
    private String phone2;
    private String adress;

    public Contacto(int id, String name, String firstSurname, String secondSurname, int photo, Date birth, String company, String email, String phone1, String phone2, String adress) {
        this.id = id;
        this.name = name;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.photo = photo;
        this.birth = birth;
        this.company = company;
        this.email = email;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.adress = adress;

    }
}
