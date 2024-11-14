package com.jonander2233.ejerciciofragmentscontactos.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jonander2233.ejerciciofragmentscontactos.R;
import com.jonander2233.ejerciciofragmentscontactos.adapters.ContactoAdapter;
import com.jonander2233.ejerciciofragmentscontactos.models.Contacto;
import com.jonander2233.ejerciciofragmentscontactos.utils.IOnClickListener;

import java.util.List;

public class ListFragment extends Fragment {
    private List<Contacto> contactos;
    private IOnClickListener clickListener;
    public interface IOnAttachListener{
        List<Contacto> getContactos();
    }

    public ListFragment() {
        super(R.layout.fragment_list_contactos);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        clickListener = (IOnClickListener) context;
        IOnAttachListener attachListener = (IOnAttachListener) context;
        contactos = attachListener.getContactos();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ContactoAdapter contactoAdapter = new ContactoAdapter(contactos,clickListener);
        RecyclerView recyclerView = view.findViewById(R.id.rvContactos);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(contactoAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

    }
}
