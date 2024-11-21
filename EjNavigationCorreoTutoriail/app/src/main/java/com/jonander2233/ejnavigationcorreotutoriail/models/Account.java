package com.jonander2233.ejnavigationcorreotutoriail.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Account implements Parcelable {
    private final int id;
    private final String name;
    private final String firstSurname;
    private final String email;
    private final List<Contact> contacts;
    private final List<Mail> mails;

    public Account(int id, String name, String firstSurname, String email, List<Contact> contacts, List<Mail> mails) {
        this.id = id;
        this.name = name;
        this.firstSurname = firstSurname;
        this.email = email;
        this.contacts = contacts;
        this.mails = mails;
        pairContact();
    }

    protected Account(Parcel in) {
        id = in.readInt();
        name = in.readString();
        firstSurname = in.readString();
        email = in.readString();
        contacts = in.createTypedArrayList(Contact.CREATOR);
        mails = in.createTypedArrayList(Mail.CREATOR);
    }

    public static final Creator<Account> CREATOR = new Creator<Account>() {
        @Override
        public Account createFromParcel(Parcel in) {
            return new Account(in);
        }

        @Override
        public Account[] newArray(int size) {
            return new Account[size];
        }
    };

    private void pairContact() {
        for (int i = 0; i < mails.size(); i++) {
            for (int j = 0; j < contacts.size(); j++) {
                if(mails.get(i).getFrom().equals(contacts.get(j).getEmail()))
                    mails.get(i).setContact(contacts.get(j));
            }
        }
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

    public List<Mail> getMails() {
        return mails;
    }

    public List<Mail> getUnreadMails(){
        List<Mail> unreadMails = new ArrayList<>();
        for (int i = 0; i < mails.size(); i++) {
            if(!mails.get(i).isReaded()){
                unreadMails.add(mails.get(i));
            }
        }
        return unreadMails;
    }
    public List<Mail> getSpamMails(){
        List<Mail> spamMails = new ArrayList<>();
        for (int i = 0; i < mails.size(); i++) {
            if(mails.get(i).isSpam()){
                spamMails.add(mails.get(i));
            }
        }
        return spamMails;
    }
    public List<Mail> getSentMails(){
        List<Mail> sentMails = new ArrayList<>();
        for (int i = 0; i < mails.size(); i++) {
            if(mails.get(i).getFrom().equals(email)){
                sentMails.add(mails.get(i));
            }
        }
        return sentMails;
    }

    public List<Mail> getRecivedMails(){
        List<Mail> recivedMails = new ArrayList<>();
        for (int i = 0; i < mails.size(); i++) {
            if(mails.get(i).getTo().equals(email)){
                recivedMails.add(mails.get(i));
            }
        }
        return recivedMails;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(firstSurname);
        parcel.writeString(email);
        parcel.writeTypedList(contacts);
        parcel.writeTypedList(mails);
    }
}
