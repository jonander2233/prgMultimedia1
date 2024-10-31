package com.jonander2233.listviewcontactospropio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListAdapter extends ArrayAdapter<Contacto> {
    private Context mContext;
    private int mResource;
    private List<Contacto> contactos;

    public ListAdapter(@NonNull Context context, int resource, List<Contacto> objects) {
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
        //contacto actual contiene un contacto de la lista con sus datos
        Contacto contactoActual = contactos.get(position);
        //creo un objeto ImageView y le asigno el imageview del xml
        ImageView ivPerfil = vistaDelElementoDeLaLista.findViewById(R.id.iv_Perfil);
        //cojo la imagen del objeto contacto y la meto en el imageview anterior
        ivPerfil.setImageResource(contactoActual.getImage());
        TextView tvName = vistaDelElementoDeLaLista.findViewById(R.id.tvName);
        tvName.setText(contactoActual.getName());
        TextView tvNumber = vistaDelElementoDeLaLista.findViewById(R.id.tvNumber);
        tvNumber.setText(String.valueOf(contactoActual.getPhoneNumber()));
        return vistaDelElementoDeLaLista;
    }
}






