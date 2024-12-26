package com.jonander2233.examen01.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jonander2233.examen01.R;
import com.jonander2233.examen01.models.Card;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Card}.
 * TODO: Replace the implementation with code for your data type.
 */
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardHolder> {
    private final List<Card> cards;

    public CardAdapter(List<Card> cards) {
        this.cards = cards;
    }

    @NonNull
    @Override
    public CardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, null);
        return new CardHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull CardHolder holder, int position) {
        Card card = cards.get(position);
        holder.bind(card);
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }


    public class CardHolder extends RecyclerView.ViewHolder {
        ImageView ivCard;
        TextView tvCardName;
        TextView tvRarity;
        TextView tvArena;
        TextView tvElixir;
        TextView tvType;

        public CardHolder(@NonNull View itemView) {
            super(itemView);
            ivCard = itemView.findViewById(R.id.ivCard);
            tvCardName = itemView.findViewById(R.id.tvCardName);
            tvRarity = itemView.findViewById(R.id.tvRarity);
            tvArena = itemView.findViewById(R.id.tvArena);
            tvElixir = itemView.findViewById(R.id.tvElixir);
            tvType = itemView.findViewById(R.id.tvType);
        }

        public void bind(Card card) {

            String cardPhoto = card.getImage();
            int resourceId = itemView.getContext().getResources().getIdentifier(cardPhoto, "drawable", itemView.getContext().getPackageName());
            if (resourceId != 0) {
                ivCard.setImageResource(resourceId);
            } else {
                ivCard.setImageResource(R.drawable.unknown);
            }
            tvCardName.setText(card.getName());
            tvRarity.setText(card.getRarity());
            tvArena.setText(String.valueOf(card.getArena()));
            tvElixir.setText(String.valueOf(card.getElixir()));
            tvType.setText(card.getType());

        }
    }
}