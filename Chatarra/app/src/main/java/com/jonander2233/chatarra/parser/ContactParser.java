package com.jonander2233.chatarra.parser;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import com.jonander2233.chatarra.model.Contact;

public class ContactParser {
    public static List<Contact> parseContacts(Context context){
        List<Contact> result = Collections.emptyList();
        InputStream in = context.getResources().openRawResource(com.jonander2233.chatarra.R.raw.contacts);
        try {
            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);
            in.close();
            String content = new String(buffer, StandardCharsets.UTF_8);
            JSONTokener jsonTokener = new JSONTokener(content);
            JSONArray jsonArray = new JSONArray(jsonTokener);
            result = new ArrayList<>(jsonArray.length());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject contact = jsonArray.getJSONObject(i);
                Contact c = new Contact(
                        contact.getInt("id"),
                        contact.getString("name"),
                        contact.getString("firstSurname"),
                        contact.getString("secondSurname"),
                        contact.getString("photo"),
                        contact.getString("birth"),
                        contact.getString("company"),
                        contact.getString("email"),
                        contact.getString("phone1"),
                        contact.getString("phone2"),
                        contact.getString("address")
                );
                result.add(c);
            }
        } catch (IOException | JSONException e) {
            Log.e(ContactParser.class.getSimpleName(), Objects.requireNonNull(e.getMessage()));
        }
        return result;
    }
}
