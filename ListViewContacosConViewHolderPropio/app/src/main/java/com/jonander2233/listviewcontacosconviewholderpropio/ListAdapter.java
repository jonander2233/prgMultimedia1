package com.jonander2233.listviewcontacosconviewholderpropio;

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
        View vistaItemActual = convertView;
        ViewHolder viewHolder;
        if (vistaItemActual == null) {
            vistaItemActual = LayoutInflater.from(mContext).inflate(R.layout.elemento_lista,null);
            viewHolder = new ViewHolder();
            //en el viewHolder actual se guardan solo las referencias a los textview e imageview
            viewHolder.ivPerfil = vistaItemActual.findViewById(R.id.iv_Perfil);
            viewHolder.tvName = vistaItemActual.findViewById(R.id.tvName);
            viewHolder.tvNumber = vistaItemActual.findViewById(R.id.tvNumber);
            //utilizamos el viewHolder recien creado como tag de la vista del item actual, entonces unimos los datos de este viewHolder con la vista actual
            vistaItemActual.setTag(viewHolder);
        }else {
            //recuperamos el viewHolder y por lo tanto los tags de la vista actual
            viewHolder = (ViewHolder)vistaItemActual.getTag();

        }
        //contacto actual contiene un contacto de la lista con sus datos
        Contacto contactoActual = contactos.get(position);
        //creo un objeto ImageView y le asigno el imageView contenido en el viewHolder
        ImageView ivPerfil = viewHolder.ivPerfil;
        //cojo la imagen del objeto contacto y la meto en el imageview anterior
        ivPerfil.setImageResource(contactoActual.getImage());
        TextView tvName = viewHolder.tvName;
        tvName.setText(contactoActual.getName());
        TextView tvNumber = viewHolder.tvNumber;
        tvNumber.setText(String.valueOf(contactoActual.getPhoneNumber()));
        return vistaItemActual;
    }
    private static class ViewHolder{
        ImageView ivPerfil;
        TextView tvName;
        TextView tvNumber;
    }
}












