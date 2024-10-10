package com.jonander2233.listviewpaisesconviewholder;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CountryAdapter extends ArrayAdapter<Country>{
    private ArrayList<Country> countriesArrayList;

    public CountryAdapter(@NonNull Context context, ArrayList<Country> countriesArray) {
        super(context, R.layout.listitem_country, countriesArray);
        this.countriesArrayList = countriesArray;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listitem_country, null);

        TextView tvCountryName = item.findViewById(R.id.tvCountryName);
        TextView tvCapital = item.findViewById(R.id.tvCapital);
        TextView tvPopulation = item.findViewById(R.id.tvPopulation);
        ImageView ivFlag = item.findViewById(R.id.ivFlag);

        Country country = countriesArrayList.get(position);
        tvCountryName.setText(country.getCountryName());
        tvCapital.setText(country.getCapital());
        tvPopulation.setText(String.valueOf(country.getPopulation()));

        Resources res = getContext().getResources();
        String flagName = "_" + country.getCountryCode().toLowerCase();
        int resourceId = res.getIdentifier(flagName, "drawable", getContext().getPackageName());
        if (resourceId != 0) {
            ivFlag.setImageResource(resourceId);
        }

        return item;
    }
}
