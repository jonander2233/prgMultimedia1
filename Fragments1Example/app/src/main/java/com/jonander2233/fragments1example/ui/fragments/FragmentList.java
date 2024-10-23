package com.jonander2233.fragments1example.ui.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.jonander2233.fragments1example.R;
import com.jonander2233.fragments1example.models.Person;
import com.jonander2233.fragments1example.models.PersonAdapter;

import java.util.List;

public class FragmentList extends Fragment {
    public interface IOnAttachListener{
        List<Person> getPersons();
    }

    private List<Person> persons;

    public FragmentList(){
        super(R.layout.fragment_list);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        IOnAttachListener listener = (IOnAttachListener) requireActivity();
        persons = listener.getPersons();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rvList = view.findViewById(R.id.rvList);
        PersonAdapter adapter = new PersonAdapter();
    }
}
