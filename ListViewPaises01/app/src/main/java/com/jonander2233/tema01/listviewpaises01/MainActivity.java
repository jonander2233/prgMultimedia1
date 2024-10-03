package com.jonander2233.tema01.listviewpaises01;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static ArrayList<Country> countries;

    private static ListView listaPaises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            countries = CountryParser.parseToArrayList(this);
            CountryAdapter countryAdapter = new CountryAdapter(this, countries);

        } catch (Exception e) {
            e.printStackTrace();
        }







        CountryAdapter ca = new CountryAdapter(this, countries);

    }


}