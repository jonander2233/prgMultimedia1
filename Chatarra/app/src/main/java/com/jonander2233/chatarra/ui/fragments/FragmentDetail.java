package com.jonander2233.chatarra.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jonander2233.chatarra.R;
import com.jonander2233.chatarra.model.Contact;

public class FragmentDetail extends Fragment{
    public interface IOnAttachListener{
        Contact getSelectedContact();
    }

    private IOnAttachListener attachListener;
    private TextView tvNombre;
    private TextView tvApellidos;
    private TextView tvFechaNacimiento;
    private TextView tvDireccion;
    private TextView tvTelefono1;
    private TextView tvTelefono2;
    private TextView tvEmail;
    private TextView tvCompany;

    public FragmentDetail() {
        super(R.layout.fragment_detail);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvNombre = view.findViewById(R.id.txt_nombre);
        tvApellidos = view.findViewById(R.id.txt_apellidos);
        tvFechaNacimiento = view.findViewById(R.id.txt_fecha_nacimiento);
        tvDireccion = view.findViewById(R.id.txt_direccion);
        tvTelefono1 = view.findViewById(R.id.txt_telefono1);
        tvTelefono2 = view.findViewById(R.id.txt_telefono2);
        tvEmail = view.findViewById(R.id.txt_email);
        tvCompany = view.findViewById(R.id.txt_empresa);

        if (attachListener != null) {
            updateContact(attachListener.getSelectedContact());
        }

    }

    public void updateContact(Contact contact) {
        if (contact != null) {
            tvNombre.setText(getString(R.string.nombre, contact.getName()));
            String apellidos = contact.getFirstSurname() + " " + contact.getSecondSurname();
            tvApellidos.setText(getString(R.string.apellidos, apellidos));
            tvFechaNacimiento.setText(contact.getBirth());
            tvDireccion.setText(getString(R.string.direccion, contact.getAddress()));
            tvTelefono1.setText(getString(R.string.telefono1, contact.getPhone1()));
            tvTelefono2.setText(getString(R.string.telefono2, contact.getPhone2()));
            tvEmail.setText(getString(R.string.email, contact.getEmail()));
            tvCompany.setText(getString(R.string.company, contact.getCompany()));
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        attachListener = (IOnAttachListener) requireActivity();
    }
}
