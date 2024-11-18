package com.jonander2233.ejerciciofragmentscontactos;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.jonander2233.ejerciciofragmentscontactos.fragments.DetailFragment;
import com.jonander2233.ejerciciofragmentscontactos.fragments.ListFragment;
import com.jonander2233.ejerciciofragmentscontactos.models.Contacto;
import com.jonander2233.ejerciciofragmentscontactos.transformers.ContactParser;
import com.jonander2233.ejerciciofragmentscontactos.utils.IOnClickListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ListFragment.IOnAttachListener, IOnClickListener, DetailFragment.IOnAttachListener {
    private static final String CONTACTS_KEY = "contacts key for saved instance";
    private static final String SELECTED_CONTACT_KEY = "contact key for saved instance";
    private boolean hasDetail;
    private ArrayList<Contacto> contactos;
    private Contacto contactoSeleccionado;
    private DetailFragment detailFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.contacts);
        fragmentManager = getSupportFragmentManager();
        hasDetail = findViewById(R.id.fcvDetailFragment) != null;
        if(hasDetail){
            detailFragment = (DetailFragment) fragmentManager.findFragmentById(R.id.fcvDetailFragment);
            if (!(fragmentManager.findFragmentById(R.id.fcvListFragment) instanceof ListFragment)) {
                fragmentManager.popBackStack();
            }
        }

        if(savedInstanceState != null){
            contactos = savedInstanceState.getParcelableArrayList(CONTACTS_KEY);
            contactoSeleccionado = savedInstanceState.getParcelable(SELECTED_CONTACT_KEY);
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setTitle(R.string.contacts);
    }

    public void loadData(){
        ContactParser contactParser = new ContactParser(this);
        if(contactParser.parse()){
            this.contactos = (ArrayList<Contacto>) contactParser.getContactos();
        }
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelableArrayList(CONTACTS_KEY,contactos);
        outState.putParcelable(SELECTED_CONTACT_KEY,contactoSeleccionado);
        super.onSaveInstanceState(outState);
    }


    @Override
    public Contacto getContacto() {
        if (contactoSeleccionado == null) {
            contactoSeleccionado = contactos.get(0);
        }

        setTitle(contactoSeleccionado.getName() + " " + contactoSeleccionado.getFirstSurname());
        return contactoSeleccionado;
    }

    @Override
    public List<Contacto> getContactos() {
        if(contactos == null){
            loadData();
        }
        return contactos;
    }

    @Override
    public void onClick(int position) {
        contactoSeleccionado = contactos.get(position);
        if(hasDetail){
            detailFragment.showDetail(contactoSeleccionado);
        }else{
            fragmentManager.beginTransaction().setReorderingAllowed(true).addToBackStack(null).replace(R.id.fcvListFragment,DetailFragment.class,null).commit();
        }
    }
}