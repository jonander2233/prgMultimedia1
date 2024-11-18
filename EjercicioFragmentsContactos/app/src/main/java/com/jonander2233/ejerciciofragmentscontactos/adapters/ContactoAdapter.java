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
    private final IOnClickListener listener;
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
        holder.bindContacto(contactos.get(position));
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public class ContactoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView ivFotoContacto;
        private TextView tvNombre;
        private TextView tvApellidos;
        private TextView tvDireccion;
        private TextView tvEmpresa;
        private TextView tvFechaNacimiento;
        private TextView tvTelefono1;
        private TextView tvTelefono2;
        private TextView tvEmail;
        private String apellidosString;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFotoContacto = itemView.findViewById(R.id.ivFotoContacto);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvApellidos = itemView.findViewById(R.id.tvApellidos);
            tvDireccion = itemView.findViewById(R.id.tvDireccion);
            tvEmpresa = itemView.findViewById(R.id.tvEmpresa);
            tvFechaNacimiento = itemView.findViewById(R.id.tvFechaNacimiento);
            tvTelefono1 = itemView.findViewById(R.id.tvTelefono1);
            tvTelefono2 = itemView.findViewById(R.id.tvTelefono2);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            itemView.setOnClickListener(this);
        }
        public void bindContacto(Contacto contacto){
            tvNombre.setText(contacto.getName());
            apellidosString = contacto.getFirstSurname() + " " + contacto.getSecondSurname();
            tvApellidos.setText(apellidosString);
            //todo crash here
            tvDireccion.setText(contacto.getAddress());
            tvEmpresa.setText(contacto.getCompany());
            tvFechaNacimiento.setText(contacto.getBirth());
            tvTelefono1.setText(contacto.getPhone1());
            tvTelefono2.setText(contacto.getPhone2());
            tvEmail.setText(contacto.getEmail());
        }

        @Override
        public void onClick(View view) {
            if(listener != null)
                listener.onClick(getAdapterPosition());
        }
    }
}
