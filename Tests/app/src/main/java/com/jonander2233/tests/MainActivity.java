package com.jonander2233.tests;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String[] nombres = {"Juan", "María", "Pedro", "Ana", "Luis"};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado);
        ListView listaVista = findViewById(R.id.listaVistas);


    }
}