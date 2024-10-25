package com.jonander2233.chatarra.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jonander2233.chatarra.IOnClickListener;
import com.jonander2233.chatarra.R;
import com.jonander2233.chatarra.model.Contact;
import com.jonander2233.chatarra.model.ContactAdapter;

import java.util.List;

public class FragmentList extends Fragment {
    public interface IOnAttachListener{
        List<Contact> getData();
    }
    private List<Contact> persons;
    private IOnClickListener clickListener;

    public FragmentList() {
        super(R.layout.fragment_list);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rvList = view.findViewById(R.id.rvList);
        ContactAdapter adapter = new ContactAdapter(requireContext(), persons, clickListener);
        rvList.setAdapter(adapter);
        rvList.hasFixedSize();
        rvList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        IOnAttachListener listener = (IOnAttachListener) requireActivity();
        persons = listener.getData();
        clickListener = (IOnClickListener) requireActivity();

    }
}
