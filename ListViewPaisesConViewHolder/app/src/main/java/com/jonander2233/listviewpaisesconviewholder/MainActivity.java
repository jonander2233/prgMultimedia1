package com.jonander2233.listviewpaisesconviewholder;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static ArrayList<Country> countries;
    private static ListView listaPaises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countries = new ArrayList<>();
        ListView listaPaises = findViewById(R.id.lvCountries);
        try {
            countries = CountryParser.parseToArrayList(this);
            CountryAdapter countryAdapter = new CountryAdapter(this, countries);
            listaPaises.setAdapter(countryAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}