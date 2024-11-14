package com.jonander2233.ejerciciofragmentscontactos.transformers;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jonander2233.ejerciciofragmentscontactos.R;
import com.jonander2233.ejerciciofragmentscontactos.models.Contacto;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JSONContactos {
    private static JSONContactos instance;
    private final Gson gson;
    private Context context;


    private JSONContactos(Context context) {
        this.gson = new Gson();
        this.context = context;
    }

    // Método para obtener la instancia única (patrón Singleton)
    public static JSONContactos getInstance(Context context) {
        if (instance == null) {
            instance = new JSONContactos(context);
        }
        return instance;
    }

    public List<Contacto> transformToObject(int resourceID) {
        InputStream is = context.getResources().openRawResource(resourceID);
        InputStreamReader reader = new InputStreamReader(is);
        List<Contacto> contactos = gson.fromJson(reader, new TypeToken<List<Contacto>>(){}.getType());
        return contactos;
    }

}

