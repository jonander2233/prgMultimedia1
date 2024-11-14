package com.jonander2233.ejerciciofragmentscontactos.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jonander2233.ejerciciofragmentscontactos.R;

public class DetailFragment extends Fragment {
    public interface IOnAttachListener{
        String getContactosText();

    }
    public DetailFragment(){
        super(R.layout.detail_contacto);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

}
