package com.jonander2233.fragmentscontactlist.ui.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jonander2233.fragmentscontactlist.R;

public class DetailFragment extends Fragment {

    public interface IOnAttachListener {
        String getMailText();
    }

    private TextView tvDetail;
    private String mailText;

    public DetailFragment() {
        super(R.layout.fragment_detail);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvDetail = view.findViewById(R.id.tvDetail);
        if (mailText != null) {
            showDetail(mailText);
        }
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        IOnAttachListener attachListener = (IOnAttachListener) context;
        mailText = attachListener.getMailText();
    }

    public void showDetail(String mailText) {
        this.mailText = mailText;
        tvDetail.setText(mailText);
    }
}
