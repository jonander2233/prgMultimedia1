package com.jonander2233.fragmentscontactlist.models;

import java.io.Serializable;
import java.util.Objects;

public class Contact implements Serializable {
    private final String name;
    private final String lastName;
    private final String adress;
    private final String company;
    private final String phone1;
    private final String phone2;
    private final String email;
    private final String birthdate;

    public Contact(String name, String lastName, String adress, String company, String phone1, String phone2, String email, String birthdate) {
        this.name = name;
        this.lastName = lastName;
        this.adress = adress;
        this.company = company;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.email = email;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAdress() {
        return adress;
    }

    public String getCompany() {
        return company;
    }

    public String getPhone1() {
        return phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthdate() {
        return birthdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name) && Objects.equals(lastName, contact.lastName) && Objects.equals(adress, contact.adress) && Objects.equals(company, contact.company) && Objects.equals(phone1, contact.phone1) && Objects.equals(phone2, contact.phone2) && Objects.equals(email, contact.email) && Objects.equals(birthdate, contact.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, adress, company, phone1, phone2, email, birthdate);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", adress='" + adress + '\'' +
                ", company='" + company + '\'' +
                ", phone1='" + phone1 + '\'' +
                ", phone2='" + phone2 + '\'' +
                ", email='" + email + '\'' +
                ", birthdate='" + birthdate + '\'' +
                '}';
    }
}
