package com.jonander2233.listviewcontacosconviewholderpropio;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.jonander2233.listviewcontacosconviewholderpropio.Contacto;
import com.jonander2233.listviewcontacosconviewholderpropio.ListAdapter;
import com.jonander2233.listviewcontacosconviewholderpropio.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Contacto> contactos = new ArrayList<>();
    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_contactos);
        mListView = findViewById(R.id.lvContactos);

        for (int i = 0; i < 99; i++) {
            contactos.add(new Contacto(R.mipmap.ic_launcher,Integer.parseInt("1234567"+""+i),"usuario" + i));
        }

        ListAdapter mAdapter = new ListAdapter(this,R.layout.lista_contactos,contactos);
        mListView.setAdapter(mAdapter);
    }
}