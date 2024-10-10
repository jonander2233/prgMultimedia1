package com.jonander2233.recyclerviewcontactos;

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
import java.util.List;

public class ContactParser {
    public static List<Contact> parse(Context context) {
        List<Contact> result = new ArrayList<>();
        InputStream in = context.getResources().openRawResource(R.raw.contacts);
        try{

            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);
            in.close();
            String content = new String(buffer, StandardCharsets.UTF_8);
            JSONTokener jsonTokener = new JSONTokener(content);
            JSONArray array = new JSONArray(jsonTokener);
            result = new ArrayList<>(array.length());
            for(int i = 0; i < array.length(); i++) {
                JSONObject  jsonObject = array.getJSONObject(i);
                String name = jsonObject.getString("name");
                String firstname = jsonObject.getString("firstName");
                String secondSurname = jsonObject.getString("secondName");
                String phone1 = jsonObject.getString("phone1");
                String phone2 = jsonObject.getString("phone2");
                String email = jsonObject.getString("email");
                result.add(new Contact(name,firstname,secondSurname,phone1,phone2,email));

            }

        }catch (IOException ioe){
            Log.e(ContactParser.class.getName(),ioe.getMessage());
            result = null;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
