package com.jonander2233.fragmentscontactopropio;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterContactos extends RecyclerView.Adapter<AdapterContactos.ViewHolderContacto>{
    List<Contacto> contactos;

    public AdapterContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    @NonNull
    @Override
    public ViewHolderContacto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento_lista,null);
        AdapterContactos.ViewHolderContacto viewHolder = new AdapterContactos.ViewHolderContacto(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderContacto holder, int position) {
        holder.bind(contactos.get(position));
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    protected class ViewHolderContacto extends RecyclerView.ViewHolder{
        ImageView ivProfilePic;
        TextView phoneNumber;
        TextView name;

        public ViewHolderContacto(@NonNull View itemView) {
            super(itemView);
            this.ivProfilePic = itemView.findViewById(R.id.iv_Perfil);
            this.phoneNumber = itemView.findViewById(R.id.tvNumber);
            this.name = itemView.findViewById(R.id.tvName);
        }
        public void bind(Contacto contacto){
            ivProfilePic.setImageResource(contacto.getImage());
            phoneNumber.setText(String.valueOf(contacto.getPhoneNumber()));
            name.setText(contacto.getName());
        }
    }
}
