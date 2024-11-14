package com.jonander2233.ejerciciofragmentscontactos.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jonander2233.ejerciciofragmentscontactos.R;
import com.jonander2233.ejerciciofragmentscontactos.models.Contacto;

public class DetailFragment extends Fragment {
    public interface IOnAttachListener{
        Contacto getContacto();
    }
    private Contacto contacto;
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

    public DetailFragment(){
        super(R.layout.detail_contacto);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        IOnAttachListener attachListener = (IOnAttachListener) context;
        contacto = attachListener.getContacto();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        ivFotoContacto = view.findViewById(R.id.ivFotoContacto);
        tvNombre = view.findViewById(R.id.tvNombre);
        tvApellidos = view.findViewById(R.id.tvApellidos);
        tvDireccion = view.findViewById(R.id.tvDireccion);
        tvEmpresa = view.findViewById(R.id.tvEmpresa);
        tvFechaNacimiento = view.findViewById(R.id.tvFechaNacimiento);
        tvTelefono1 = view.findViewById(R.id.tvTelefono1);
        tvTelefono2 = view.findViewById(R.id.tvTelefono2);
        tvEmail = view.findViewById(R.id.tvEmail);
    }
    public void showDetail(Contacto contacto){
        this.contacto = contacto;
        tvNombre.setText(contacto.getName());
        this.apellidosString = contacto.getFirstSurname() + " " + contacto.getSecondSurname();
        tvApellidos.setText(this.apellidosString);
        tvDireccion.setText(contacto.getAddress());
        tvEmpresa.setText(contacto.getCompany());
        tvFechaNacimiento.setText(contacto.getBirth());
        tvTelefono1.setText(contacto.getPhone1());
        tvTelefono2.setText(contacto.getPhone2());
        tvEmail.setText(contacto.getEmail());
    }
}
