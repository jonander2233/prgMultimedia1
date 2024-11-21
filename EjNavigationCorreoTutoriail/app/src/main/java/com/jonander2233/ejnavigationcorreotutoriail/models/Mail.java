package com.jonander2233.ejnavigationcorreotutoriail.models;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.List;

public class Mail implements Parcelable {
    private Contact contact;
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
        this.contact = UnknownContact.getUnknownContact();
    }

    protected Mail(Parcel in) {
        contact = in.readParcelable(Contact.class.getClassLoader());
        from = in.readString();
        to = in.readString();
        subject = in.readString();
        body = in.readString();
        sentOn = in.readString();
        readed = in.readByte() != 0;
        deleted = in.readByte() != 0;
        spam = in.readByte() != 0;
    }

    public static final Creator<Mail> CREATOR = new Creator<Mail>() {
        @Override
        public Mail createFromParcel(Parcel in) {
            return new Mail(in);
        }

        @Override
        public Mail[] newArray(int size) {
            return new Mail[size];
        }
    };

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Contact getContact() {
        return contact;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public String getSentOn() {
        return sentOn;
    }

    public boolean isReaded() {
        return readed;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public boolean isSpam() {
        return spam;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeParcelable(contact, i);
        parcel.writeString(from);
        parcel.writeString(to);
        parcel.writeString(subject);
        parcel.writeString(body);
        parcel.writeString(sentOn);
        parcel.writeByte((byte) (readed ? 1 : 0));
        parcel.writeByte((byte) (deleted ? 1 : 0));
        parcel.writeByte((byte) (spam ? 1 : 0));
    }
}
