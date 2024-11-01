package com.jonander2233.listviewcontactosconrecyclerviewpropio;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Contacto> contactos = new ArrayList<>();
    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadData();

        setupRecyclerView();

    }

    private void loadData() {
        for (int i = 0; i < 99; i++) {
            contactos.add(new Contacto(R.mipmap.ic_launcher,Integer.parseInt("1234567"+""+i),"usuario" + i));
        }
    }

    private void setupListView(){
        setContentView(R.layout.lista_contactos);
        mListView = findViewById(R.id.lvContactos);
        ListAdapter mAdapter = new ListAdapter(this,R.layout.lista_contactos,contactos);
        mListView.setAdapter(mAdapter);
    }

    private void setupRecyclerView(){
        setContentView(R.layout.recycler_contactos);
        RecyclerView recyclerView = findViewById(R.id.rvContactos);
        ContactoAdapterRecyclerView adapter = new ContactoAdapterRecyclerView(contactos);
        recyclerView.setAdapter(adapter);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));
    }
}