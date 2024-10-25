package com.jonander2233.fragmentscontactlist.ui.fragments;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jonander2233.fragmentscontactlist.models.adapters.MailAdapter;
import com.jonander2233.fragmentscontactlist.interfaces.IOnClickListener;
import com.jonander2233.fragmentscontactlist.R;
import com.jonander2233.fragmentscontactlist.models.Mail;

public class ListFragment extends Fragment {
    private Mail[] mails;
    private IOnClickListener clickListener;
    private int selectedMail;

    // Esta interfaz permitirá al Fragment comunicarse con la Activity
    public interface IOnAttachListener {
        Mail[] getMails();
        int getSelectedMail();
    }

    public ListFragment() {
        super(R.layout.fragment_list);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MailAdapter mailAdapter = new MailAdapter(mails);
        mailAdapter.setListener(clickListener);
        RecyclerView recyclerView = view.findViewById(R.id.recView);
        // Esta línea permite aplicar optimizaciones ya que Android sabe
        // que no va a cambiar de tamaño
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mailAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.scrollToPosition(selectedMail);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        // Este método se ejecuta cuando el Fragment es cargado. Por tanto es un buen
        // momento para que el Fragment solicite/envíe (según el caso) a la Activity
        super.onAttach(context);
        clickListener = (IOnClickListener) context;
        IOnAttachListener attachListener = (IOnAttachListener) context;
        mails = attachListener.getMails();
        selectedMail = attachListener.getSelectedMail();
    }
}
