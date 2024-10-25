package com.jonander2233.tests;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Adaptador extends ArrayAdapter<Contacto> {
    private Context mContext;
    private int mResource;
    private List<Contacto> contactos;

    public Adaptador(@NonNull Context context, int resource, List<Contacto> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.contactos = objects;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View vistaDelElementoDeLaLista = convertView;
        if (vistaDelElementoDeLaLista == null) {
            vistaDelElementoDeLaLista = LayoutInflater.from(mContext).inflate(R.layout.elemento_lista,null);
        }
        Contacto contactoActual = contactos.get(position);
        ImageView ivPerfil = vistaDelElementoDeLaLista.findViewById(R.id.ivPerfil);


        return vistaDelElementoDeLaLista;
    }
}






