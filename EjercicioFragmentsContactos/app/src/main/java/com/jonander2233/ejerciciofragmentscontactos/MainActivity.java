package com.jonander2233.ejerciciofragmentscontactos;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.jonander2233.ejerciciofragmentscontactos.fragments.DetailFragment;
import com.jonander2233.ejerciciofragmentscontactos.fragments.ListFragment;
import com.jonander2233.ejerciciofragmentscontactos.models.Contacto;
import com.jonander2233.ejerciciofragmentscontactos.transformers.ContactParser;
import com.jonander2233.ejerciciofragmentscontactos.utils.IOnClickListener;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ListFragment.IOnAttachListener, IOnClickListener, DetailFragment.IOnAttachListener {
    private static final String CONTACTS_KEY = "com.jonander2233.ejerciciofragmentscontactos.contacts";
    private static final String SELECTED_CONTACT_KEY = "com.jonander2233.ejerciciofragmentscontactos.selectedcontact";
    private DetailFragment detailFragment;
    private boolean hasDetail;
    private List<Contacto> contactos;
    private Contacto contactoSeleccionado;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null){
            ContactParser jc = new ContactParser(this);
            jc.parse();
            contactos = jc.getContactos();
        }
        if(savedInstanceState != null){
            contactos = (List<Contacto>) savedInstanceState.getParcelableArray(CONTACTS_KEY);
        }
    }

    @Override
    public Contacto getContacto() {
        return null;
    }

    @Override
    public List<Contacto> getContactos() {
        return Collections.emptyList();
    }

    @Override
    public void onClick(int position) {

    }
}