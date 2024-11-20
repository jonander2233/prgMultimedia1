package com.jonander2233.ejnavigationcorreo.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jonander2233.ejnavigationcorreo.models.Contact;

import java.util.List;

public class receivedFragment extends Fragment {
    private List<Contact> contacts;
    public interface IOnAttachListener{
        List<Contact> getContactos();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
