package com.jonander2233.fragmentscontactlist.models.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jonander2233.fragmentscontactlist.R;
import com.jonander2233.fragmentscontactlist.interfaces.IOnClickListener;
import com.jonander2233.fragmentscontactlist.models.Contact;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    private final Contact[] contacts;
    private IOnClickListener listener;

    public ContactAdapter(Contact[] contacts) {
        this.contacts = contacts;
    }
    public void setListener(IOnClickListener listener){
        this.listener = listener;
    }
    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /* Cargamos el layout preparado para la visualización en formato lista */
        View layout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_mail, parent, false);

        /* Creamos el ViewHolder personalizado y lo devolvemos */
        return new ContactAdapter(layout);
    }
