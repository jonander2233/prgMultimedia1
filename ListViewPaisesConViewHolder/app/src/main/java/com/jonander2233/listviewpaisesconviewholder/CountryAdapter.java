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
        View layout = convertView;
        ViewHolder viewHolder;
        if (layout == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            layout = inflater.inflate(R.layout.listitem_country, null);
            viewHolder = new ViewHolder();
            viewHolder.ivFlag = layout.findViewById(R.id.ivFlag);
            viewHolder.tvCountryName = layout.findViewById(R.id.tvCountryName);
            viewHolder.tvCountryCapital = layout.findViewById(R.id.tvCapital);
            viewHolder.tvCountryPopulation = layout.findViewById(R.id.tvPopulation);
            layout.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) layout.getTag();
        }
        Country country = countriesArrayList.get(position);
        try {

        }

        View item = inflater.inflate(R.layout.listitem_country, null);

        TextView tvCountryName = item.findViewById(R.id.tvCountryName);
        TextView tvCapital = item.findViewById(R.id.tvCapital);
        TextView tvPopulation = item.findViewById(R.id.tvPopulation);
        ImageView ivFlag = item.findViewById(R.id.ivFlag);

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

    static class ViewHolder {
        /** Para guardar la referencia al componente que muestra la bandera del país */
        ImageView ivFlag;
        /** Para guardar la referencia al componente que muestra el nombre del país */
        TextView tvCountryName;
        /** Para guardar la referencia al componente que muestra el nombre de la capital del país */
        TextView tvCountryCapital;
        /** Para guardar la referencia al componente que muestra el número de habitantes del país */
        TextView tvCountryPopulation;
    }
}
