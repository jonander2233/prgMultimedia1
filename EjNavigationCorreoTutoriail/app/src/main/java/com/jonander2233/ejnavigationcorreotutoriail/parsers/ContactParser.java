package com.jonander2233.ejnavigationcorreotutoriail.parsers;


import android.content.Context;
import android.util.Log;

import com.jonander2233.ejnavigationcorreotutoriail.R;
import com.jonander2233.ejnavigationcorreotutoriail.models.Account;
import com.jonander2233.ejnavigationcorreotutoriail.models.Contact;
import com.jonander2233.ejnavigationcorreotutoriail.models.Mail;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ContactParser {
    private Account account; // Objeto Account
    private final InputStream contactsFile;
    private List<Mail> mails;
    public ContactParser(Context context) {
        this.contactsFile = context.getResources().openRawResource(R.raw.correos);
    }

    public boolean parse() {
        boolean parsed = false;
        String json = null;
        try {
            int size = contactsFile.available();
            byte[] buffer = new byte[size];
            contactsFile.read(buffer);
            contactsFile.close();
            json = new String(buffer, StandardCharsets.UTF_8);
            JSONTokener tokener = new JSONTokener(json);
            JSONArray rootArray = new JSONArray(tokener);

            if (rootArray.length() > 0) {
                JSONObject rootObject = rootArray.getJSONObject(0);

                // Procesar "myAccount"
                JSONObject myAccountObject = rootObject.getJSONObject("myAccount");
                int accountId = myAccountObject.getInt("id");
                String accountName = myAccountObject.getString("name");
                String accountFirstSurname = myAccountObject.getString("firstSurname");
                String accountEmail = myAccountObject.getString("email");

                // Procesar "contacts"
                JSONArray contactsArray = rootObject.getJSONArray("contacts");
                List<Contact> contactos = new ArrayList<>();
                for (int i = 0; i < contactsArray.length(); i++) {
                    JSONObject jsonObject = contactsArray.getJSONObject(i);
                    int id = jsonObject.getInt("id");
                    String name = jsonObject.getString("name");
                    String firstSurname = jsonObject.getString("firstSurname");
                    String secondSurname = jsonObject.optString("secondSurname", ""); // Manejar opcional
                    int foto = jsonObject.getInt("foto");
                    String birth = jsonObject.getString("birth");
                    String email = jsonObject.getString("email");
                    String phone1 = jsonObject.getString("phone1");
                    String phone2 = jsonObject.getString("phone2");
                    String address = jsonObject.getString("address");

                    contactos.add(new Contact(id, name, firstSurname, secondSurname, email, birth, phone1, phone2, address, foto));
                }
                // Procesar "mails"
                JSONArray mailsJSON = rootObject.getJSONArray("mails");
                mails = new ArrayList<>();
                for (int i = 0; i < mailsJSON.length() ; i++) {
                    JSONObject jsonObject = mailsJSON.getJSONObject(i);
                    String from = jsonObject.getString("from");
                    String to = jsonObject.getString("to");
                    String subject = jsonObject.getString("subject");
                    String body = jsonObject.getString("body");
                    String sentOn = jsonObject.getString("sentOn");
                    boolean readed = jsonObject.getBoolean("readed");
                    boolean deleted = jsonObject.getBoolean("deleted");
                    boolean spam = jsonObject.getBoolean("spam");
                    mails.add(new Mail(from,to,subject,body,sentOn,readed,deleted,spam));
                }

                // Crear instancia de Account
                this.account = new Account(accountId, accountName, accountFirstSurname, accountEmail, contactos,mails);
                parsed = true;
            }
        } catch (Exception e) {
            Log.e("ContactParser", "Error parsing JSON: " + e.getLocalizedMessage());
        }
        return parsed;
    }

    public Account getAccount() {
        return this.account;
    }

}
