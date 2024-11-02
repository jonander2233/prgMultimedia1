package com.jonander2233.listviewcontactosconrecyclerviewpropio;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
//para hacer un adaptador de recyclerView, extiendo Adapter de la clase Recyclerview y como parametro <> se usará viewholder de la clase contactoAdapterRecyclerView
public class ContactoAdapterRecyclerView extends RecyclerView.Adapter<ContactoAdapterRecyclerView.ContactoViewHolder> {
    private final List<Contacto> contactos;
    //constructor que recibe una lista de contactos
    public ContactoAdapterRecyclerView(List<Contacto> contactos) {
        this.contactos = contactos;
    }


    @NonNull
    @Override
    //se ejecuta cada vez que crea una vista nueva, es decir cuando carga las primeras vistas
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento_lista, null);
        return new ContactoViewHolder(itemView);
    }

    @Override
    //se encarga de bindear los datos con las vistas recicladas
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {
        holder.bindContacto(contactos.get(position));
    }

    @Override
    //devuelve la cantidad de elementos de la lista
    public int getItemCount() {
        return contactos.size();
    }



    public static class ContactoViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivPerfil;
        private TextView tvName;
        private TextView tvNumber;
        public ContactoViewHolder(View item){
            super(item);
            ivPerfil = item.findViewById(R.id.iv_Perfil);
            tvName = item.findViewById(R.id.tvName);
            tvNumber = item.findViewById(R.id.tvNumber);
        }

        public void bindContacto(Contacto contacto){
            tvName.setText(contacto.getName());
            tvNumber.setText(String.valueOf(contacto.getPhoneNumber()));
            ivPerfil.setImageResource(contacto.getImage());
        }
    }
}
