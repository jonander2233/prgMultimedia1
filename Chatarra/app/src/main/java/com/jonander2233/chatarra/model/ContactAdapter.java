package com.jonander2233.chatarra.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jonander2233.chatarra.IOnClickListener;
import com.jonander2233.chatarra.R;
import com.jonander2233.chatarra.R.*;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter {
    private List<Contact> contacts;
    private LayoutInflater inflater;
    private IOnClickListener listener;

    public ContactAdapter(@NonNull Context context, List<Contact> contacts, IOnClickListener listener) {
        inflater = LayoutInflater.from(context);
        this.contacts = contacts;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View countryView = inflater.inflate(layout.item_person, parent, false);
        return new ViewHolder(countryView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder2 = (ViewHolder) holder;
        Contact currentContact = contacts.get(position);
        //holder2.bind(position, listener);
        String photo = currentContact.getPhoto();

        StringBuilder sb = new StringBuilder();
        sb.append(currentContact.getName()).append(" ").append(currentContact.getFirstSurname()).append(" ").append(currentContact.getSecondSurname());
        holder2.phone1.setText(currentContact.getPhone1());
        holder2.fullName.setText(sb.toString());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    private static class ViewHolder extends RecyclerView.ViewHolder{
        TextView fullName;
        TextView phone1;

        public ViewHolder(@NonNull View itemView, IOnClickListener listener) {
            super(itemView);
            this.fullName = itemView.findViewById(R.id.fullName);
            this.phone1 = itemView.findViewById(R.id.phone1);
            itemView.setOnClickListener(v -> listener.onClick(getAdapterPosition()));
        }

        //public void bind(final int position) {
        //}
    }
}
