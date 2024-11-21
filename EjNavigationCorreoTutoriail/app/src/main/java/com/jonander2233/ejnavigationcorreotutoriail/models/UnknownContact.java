package com.jonander2233.ejnavigationcorreotutoriail.models;

public class UnknownContact {
    private static Contact unknownContact = new Contact(-1,"unknown","unknown","unknown","unknown","unknown","unknown","unknown","unknown",-1);
    public static Contact getUnknownContact() {
        return unknownContact;
    }
}
