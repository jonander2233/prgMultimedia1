package com.jonander2233.ejerciciofragmentscontactos.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Contacto {
    private static SimpleDateFormat sdf;
    private static final String format = "yyyy-MM-dd" ;
    private int id;
    private String name;
    private String firstSurname;
    private String secondSurname;
    private String photo;
    private String birth;
    private String company;
    private String email;
    private String phone1;
    private String phone2;
    private String address;



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public String getPhoto() {
        return photo;
    }

    public String getBirth() {
        return birth;
    }

    public String getCompany() {
        return company;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone1() {
        return phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public String getAddress() {
        return address;
    }

    public Contacto(int id, String name, String firstSurname, String secondSurname, String photo, String birth, String company, String email, String phone1, String phone2, String address) throws ParseException {
        this.id = id;
        this.name = name;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.photo = photo;
//        this.birth = parseDate(birth);
        this.birth = birth;
        this.company = company;
        this.email = email;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.address = address;

    }
    private static Date parseDate(String dateString) throws ParseException {
        if(sdf == null){
            sdf = new SimpleDateFormat(format);
        }
        return sdf.parse(dateString);
    }
}
