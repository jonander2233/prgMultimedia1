package com.jonander2233.fragmentsexample.models;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jonander2233.fragmentsexample.interfaces.IClickListener;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {
    private final List<Persona> persons;
    private IClickListener listener;

    public PersonAdapter(List<Persona> persons) {
        this.persons = persons;
    }
    public void setListener(IClickListener listener){
        this.listener = listener;
    }
    @NonNull
    @Override
    public PersonAdapter.PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.PersonViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class PersonViewHolder {
        public PersonViewHolder(@NonNull View itemView) {
            super();
        }
    }
}
