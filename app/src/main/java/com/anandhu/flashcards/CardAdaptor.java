package com.anandhu.flashcards;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CardAdaptor extends RecyclerView.Adapter<CardAdaptor.CardViewHolder>{
    private List<Card> cardList;
    Context context;

    public CardAdaptor(List<Card> cardList, Context context) {
        this.cardList = cardList;
        this.context = context;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View FlashCardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card, parent, false);
        CardAdaptor.CardViewHolder gvh = new CardAdaptor.CardViewHolder(FlashCardView);
        return gvh;
    }

    @Override
    public void onBindViewHolder(CardAdaptor.CardViewHolder holder, final int position) {
        holder.txtSet.setText(cardList.get(position).getWord());
        holder.txtMeaning.setText(cardList.get(position).getMeaning());

    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        TextView txtSet;
        TextView txtMeaning;
        public CardViewHolder(View view) {
            super(view);
            txtSet = view.findViewById(R.id.idSetName);
            txtMeaning = view.findViewById(R.id.idSetMeaning);
        }
    }
}
