package com.jonander2233.fragmentsexample.ui.fragments;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jonander2233.fragmentsexample.R;
import com.jonander2233.fragmentsexample.models.Persona;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final List<Persona> persons = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadData();
    }

    private void loadData() {
        for (int i = 0; i < 1000; i++) {
            persons.add(new Persona("Persona " + i, "Descripción " + i));
        }
    }
}