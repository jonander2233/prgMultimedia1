package com.jonander2233.examen01.ui.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.jonander2233.examen01.R;
import com.jonander2233.examen01.adapters.CardAdapter;
import com.jonander2233.examen01.models.Card;

import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class CardListFragment extends Fragment {
    private List<Card> cards;

    public interface IOnAttachListener{
        List<Card> getCards();
    }
    public CardListFragment() {
        super(R.layout.fragment_card_list);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        IOnAttachListener attachListener = (IOnAttachListener) context;
        cards = attachListener.getCards();
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CardAdapter mailAdapter = new CardAdapter(cards);
        RecyclerView recyclerView = view.findViewById(R.id.rvCards);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mailAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
    }
}