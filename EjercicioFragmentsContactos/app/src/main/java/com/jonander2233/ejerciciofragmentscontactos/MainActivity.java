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
    private List<Contacto> contactos;
    private Contacto contactoSeleccionado;
    private DetailFragment detailFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.contacts);
        fragmentManager = getSupportFragmentManager();

        if(findViewById(R.id.fcvDetailFragment) != null){
            detailFragment = (DetailFragment) fragmentManager.findFragmentById(R.id.fcvDetailFragment);
            if (!(fragmentManager.findFragmentById(R.id.fcvListFragment) instanceof ListFragment)) {
                fragmentManager.popBackStack();
            }
        }

        if(savedInstanceState != null){
            ContactParser jc = new ContactParser(this);
            jc.parse();
            contactos = jc.getContactos();
        }
        contactos = savedInstanceState.getParcelableArrayList(CONTACTS_KEY);



    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
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