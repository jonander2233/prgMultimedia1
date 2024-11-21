package com.jonander2233.ejnavigationcorreotutoriail.ui.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jonander2233.ejnavigationcorreotutoriail.R;
import com.jonander2233.ejnavigationcorreotutoriail.interfaces.IOnClickListener;
import com.jonander2233.ejnavigationcorreotutoriail.models.Contact;
import com.jonander2233.ejnavigationcorreotutoriail.models.Mail;

import java.util.List;

public class ListFragment extends Fragment {
    private List<Mail> mails;
    private IOnClickListener clickListener;
    public interface IOnAttachListener{
        List<Mail> getMails();
    }

    public ListFragment() {
        super(R.layout.fragment_list);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        clickListener = (IOnClickListener) context;
        IOnAttachListener attachListener = (IOnAttachListener) context;
        mails = attachListener.getMails();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}