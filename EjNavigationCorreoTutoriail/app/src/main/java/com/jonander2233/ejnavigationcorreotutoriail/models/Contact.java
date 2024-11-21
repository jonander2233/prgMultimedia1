package com.jonander2233.ejnavigationcorreotutoriail.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Contact implements Parcelable {
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

    protected Contact(Parcel in) {
        id = in.readInt();
        name = in.readString();
        surname = in.readString();
        secondSurname = in.readString();
        email = in.readString();
        birth = in.readString();
        phone1 = in.readString();
        phone2 = in.readString();
        address = in.readString();
        foto = in.readInt();
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public String getEmail() {
        return email;
    }

    public String getBirth() {
        return birth;
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

    public int getFoto() {
        return foto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(surname);
        parcel.writeString(secondSurname);
        parcel.writeString(email);
        parcel.writeString(birth);
        parcel.writeString(phone1);
        parcel.writeString(phone2);
        parcel.writeString(address);
        parcel.writeInt(foto);
    }
}
