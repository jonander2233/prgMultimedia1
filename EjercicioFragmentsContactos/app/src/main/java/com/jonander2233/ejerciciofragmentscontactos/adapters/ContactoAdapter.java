package com.jonander2233.ejerciciofragmentscontactos.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jonander2233.ejerciciofragmentscontactos.R;
import com.jonander2233.ejerciciofragmentscontactos.models.Contacto;
import com.jonander2233.ejerciciofragmentscontactos.utils.IOnClickListener;

import java.util.List;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder> {
    private final List<Contacto> contactos;
    private IOnClickListener listener;
    public ContactoAdapter(List<Contacto> contactos, IOnClickListener listener) {
        this.contactos = contactos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_contacto,null);
        return new ContactoViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {
        Contacto contacto = contactos.get(position);
        holder.bindContacto(contactos.get(position));
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }
    public void setListener(IOnClickListener listener){
        this.listener = listener;
    }


    public class ContactoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvNombre;
        private TextView tvTelefono1;
        private String apellidosString;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvTelefono1 = itemView.findViewById(R.id.tvTelefono1);
            itemView.setOnClickListener(this);
        }
        public void bindContacto(Contacto contacto){
            tvNombre.setText(contacto.getName());
            apellidosString = contacto.getFirstSurname() + " " + contacto.getSecondSurname();
            tvTelefono1.setText(contacto.getPhone1());
        }

        @Override
        public void onClick(View view) {
            if(listener != null)
                listener.onClick(getAdapterPosition());
        }
    }
}
