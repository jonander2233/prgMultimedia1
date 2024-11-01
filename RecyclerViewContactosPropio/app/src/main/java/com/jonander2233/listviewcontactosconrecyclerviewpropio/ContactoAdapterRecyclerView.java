package com.jonander2233.listviewcontactosconrecyclerviewpropio;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactoAdapterRecyclerView extends RecyclerView.Adapter<ContactoAdapterRecyclerView.ContactoViewHolder> {
    private List<Contacto> contactos;

    public ContactoAdapterRecyclerView(List<Contacto> contactos) {
        this.contactos = contactos;
    }


    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento_lista, null);
        return new ContactoViewHolder(itemLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {
        holder.bindContacto(contactos.get(position));
    }

    @Override
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
