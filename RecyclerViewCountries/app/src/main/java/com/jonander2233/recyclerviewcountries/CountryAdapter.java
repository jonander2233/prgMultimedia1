package com.jonander2233.recyclerviewcountries;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.>{
    @NonNull
    @Override
    public CountryAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CountryAdapter holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
public static class ViewHolder extends RecyclerView.ViewHolder{
    public ImageView ivFlag;
    public TextView tvCountryName;
    public TextView tvCapital;
    public TextView tvPopulation;
}
