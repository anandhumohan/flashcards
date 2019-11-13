package com.anandhu.flashcards;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CardAdaptor extends RecyclerView.Adapter<CardAdaptor.CardViewHolder>{
    private List<FlashCards> cardList;
    Context context;

    public CardAdaptor(List<FlashCards> cardList, Context context) {
        this.cardList = cardList;
        this.context = context;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View FlashCardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cards, parent, false);
        CardAdaptor.CardViewHolder gvh = new CardAdaptor.CardViewHolder(FlashCardView);
        return gvh;
    }

    @Override
    public void onBindViewHolder(CardAdaptor.CardViewHolder holder, final int position) {
        holder.txtSet.setText(cardList.get(position).getSet());
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        TextView txtSet;
        public CardViewHolder(View view) {
            super(view);
            txtSet = view.findViewById(R.id.idSetName);
        }
    }
}
