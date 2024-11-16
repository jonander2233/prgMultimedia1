package com.jonander2233.ejerciciofragmentscontactos.transformers;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jonander2233.ejerciciofragmentscontactos.R;
import com.jonander2233.ejerciciofragmentscontactos.models.Contacto;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ContactParser {
    private List<Contacto> contactos;
    private final InputStream contactsFile;

    public ContactParser(Context context) {
        this.contactsFile = context.getResources().openRawResource(R.raw.contacts);
    }
    public boolean parse(){
        boolean parsed = false;
        String json = null;
        try{
            int size = contactsFile.available();
            byte[] buffer = new byte[size];
            contactsFile.read(buffer);
            contactsFile.close();
            json = new String(buffer, StandardCharsets.UTF_8);
            JSONTokener tokener = new JSONTokener(json);
            JSONArray jsonArray = new JSONArray(tokener);
            this.contactos = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int id = jsonObject.getInt("id");
                String name = jsonObject.getString("name");
                String firstSurname = jsonObject.getString("firstSurname");
                String secondSurname = jsonObject.getString("secondSurname");
                String photo = jsonObject.getString("photo");
                String birth = jsonObject.getString("birth");
                String company = jsonObject.getString("company");
                String email = jsonObject.getString("email");
                String phone1 = jsonObject.getString("phone1");
                String phone2 = jsonObject.getString("phone2");
                String address = jsonObject.getString("address");
                contactos.add(new Contacto(id,name,firstSurname,secondSurname,photo,birth,company,email,phone1,phone2,address));
            }
            parsed = true;
        } catch (Exception e) {
            Log.e("CountryParser", "Unknown Exception: " + e.getLocalizedMessage());
        }
        return parsed;
    }
    public List<Contacto> getContactos(){
        return this.contactos;
    }
    public List<Contacto> transformToObject() {
        InputStreamReader reader = new InputStreamReader(contactsFile);
        Gson gson = new Gson();
        List<Contacto> contactos = gson.fromJson(reader, new TypeToken<List<Contacto>>(){}.getType());
        return contactos;
    }

}

