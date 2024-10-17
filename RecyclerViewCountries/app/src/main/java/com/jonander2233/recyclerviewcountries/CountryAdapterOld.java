package com.jonander2233.recyclerviewcountries;

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

public class CountryAdapterOld extends ArrayAdapter<Country>{
    private ArrayList<Country> countriesArrayList;

    public CountryAdapterOld(@NonNull Context context, ArrayList<Country> countriesArray) {
        super(context, R.layout.listitem_country, countriesArray);
        this.countriesArrayList = countriesArray;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View layoutView = convertView;
        ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(getContext());
        //Si convertView es null, significa que no hay una vista previamente creada para reutilizar, por lo que debe inflarse (crear) una nueva desde el layout XML.
        if (layoutView == null) {
            //se crea una vista usando inflater
            layoutView = inflater.inflate(R.layout.listitem_country, null);
            //creo un viewHolder y asocio los atributos al viewHolder
            viewHolder = new ViewHolder();
            viewHolder.ivFlag = layoutView.findViewById(R.id.ivFlag);
            viewHolder.tvCountryName = layoutView.findViewById(R.id.tvCountryName);
            viewHolder.tvCountryCapital = layoutView.findViewById(R.id.tvCapital);
            viewHolder.tvCountryPopulation = layoutView.findViewById(R.id.tvPopulation);
            //layoutView es un elemento View, el setTag sirve para que el viewHolder se asocie al layoutView como su etiqueta
            layoutView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) layoutView.getTag();
        }
        Country country = countriesArrayList.get(position);
        try {
            Resources res = getContext().getResources();
            String flagName = "_" + country.getCountryCode().toLowerCase();
            int resID = res.getIdentifier(flagName, "drawable", getContext().getPackageName());
            if (resID != 0) {
                viewHolder.ivFlag.setImageResource(resID);
            }else {
                resID = res.getIdentifier(flagName, "drawable", getContext().getPackageName());
                viewHolder.ivFlag.setImageResource(resID);
            }
        } catch (Exception e){

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
        int resID = res.getIdentifier(flagName, "drawable", getContext().getPackageName());
        if (resID != 0) {
            ivFlag.setImageResource(resID);
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
