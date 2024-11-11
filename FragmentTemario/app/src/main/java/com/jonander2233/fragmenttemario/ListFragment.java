package com.jonander2233.fragmenttemario;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ListFragment extends Fragment {
    private Mail[] mails;
    private IOnClickListener clickListener;
    public interface IOAttachListener{
        Mail[]getMails();
    }

    public ListFragment() {
        super(R.layout.fragment_list);
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

