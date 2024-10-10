package com.jonander2233.recyclerviewcontactos;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
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
//            result = new ArrayList<>();
            JSONTokener jsonTokener = new JSONTokener(content);
            JSONArray array = new JSONArray(jsonTokener);

        }catch (IOException ioe){
            Log.e(ContactParser.class.getName(),ioe.getMessage());
            result = null;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
