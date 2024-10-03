package com.jonander2233.tema01.spnnercountries;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner countries = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.countries_array, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countries.setAdapter(adapter);

        View.OnClickListener listener = view -> Log.d("MainActivity", "Button 2 clicked");

        Button button1 = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);

        button1.setOnClickListener(this);
        button2.setOnClickListener(listener);

        button3.setOnClickListener(v -> {
            Log.d("MainActivity", String.valueOf(v.getId()));
            Log.d("MainActivity", "Button 3 clicked");
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", String.valueOf(v.getId()));
                Log.d("MainActivity", "Button 3 clicked");
            }
        });



        Toast.makeText(MainActivity.this, R.string.selectedCountry + " " + countries.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.button) {
            Log.d("MainActivity", "Button 1 clicked");
        } else if (id == R.id.button2) {
            Log.d("MainActivity", "Button 2 clicked");
        } else if (id == R.id.button3) {
            Log.d("MainActivity", "Button 3 clicked");
        }
    }
}