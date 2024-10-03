package com.jonander2233.tema01.listviewpaises01;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CountryAdapter extends ArrayAdapter<Country>{
    private ArrayList<Country> countriesArrayList = null;

    public CountryAdapter(@NonNull Context context, ArrayList<Country> countriesArray) {
        super(context, R.layout.listitem_country, countriesArray);
        this.countriesArrayList = countriesArrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
        //no sé que hacer aquí


    }
}
