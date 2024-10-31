package com.jonander2233.listviewcontactospropio;

public class Contacto {
    private int image;
    private int phoneNumber;
    private String name;

    public Contacto(int image, int phoneNumber, String name) {
        this.image = image;
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
