package com.jonander2233.ejnavigationcorreo.models;

public class Contact {
    private int id;
    private String name;
    private String surname;
    private String secondSurname;
    private String email;
    private String birth;
    private String phone1;
    private String phone2;
    private String address;
    private int foto;

    public Contact(int id, String name, String surname, String secondSurname, String email, String birth, String phone1, String phone2, String address, int foto) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.secondSurname = secondSurname;
        this.email = email;
        this.birth = birth;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.address = address;
        this.foto = foto;
    }
}
