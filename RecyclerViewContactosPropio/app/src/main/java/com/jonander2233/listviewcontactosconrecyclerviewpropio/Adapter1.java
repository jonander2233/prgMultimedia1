package com.jonander2233.listviewcontactosconrecyclerviewpropio;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter1 extends RecyclerView.Adapter<Adapter1.ViewHolder1> {
    List<Contacto> contactos;

    public Adapter1(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    @NonNull
    @Override
    public ViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento_lista,null);
        ViewHolder1 viewHolder = new ViewHolder1(itemView);
        return (ViewHolder1)viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder1 holder, int position) {
        holder.bind(contactos.get(position));
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    protected class ViewHolder1 extends RecyclerView.ViewHolder {
        ImageView ivProfilePic;
        TextView phoneNumber;
        TextView name;

        public ViewHolder1(@NonNull View itemView) {
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
