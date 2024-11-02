package com.jonander2233.fragmentmails;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListFragment extends Fragment {
    private List<Correo> correos;
    private IOnClickListener clickListener;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CorreoAdapter correoAdapter = new CorreoAdapter(correos,clickListener);
        RecyclerView recyclerView = view.findViewById(R.id.rvListado);
    }

    public ListFragment() {
        super(R.layout.fragment_list);
    }

    public interface IOnAttachListener {
        List<Correo> getCorreos();
    }

}
