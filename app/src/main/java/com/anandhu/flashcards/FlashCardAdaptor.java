package com.anandhu.flashcards;

import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;

public class FlashCardAdaptor extends RecyclerView.Adapter<FlashCardAdaptor.FlashCardViewHolder>{
    private List<FlashCards> flashCardsList;
    Context context;

    public FlashCardAdaptor(List<FlashCards> flashCardsList, Context context) {
        this.flashCardsList = flashCardsList;
        this.context = context;
    }

    @Override
    public FlashCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View FlashCardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_flashcard, parent, false);
        FlashCardViewHolder gvh = new FlashCardViewHolder(FlashCardView);
        return gvh;
    }

    @Override
    public void onBindViewHolder(FlashCardViewHolder holder, final int position) {
        holder.txtSet.setText(flashCardsList.get(position).getSet());
    }

    @Override
    public int getItemCount() {
        return flashCardsList.size();
    }

    public class FlashCardViewHolder extends RecyclerView.ViewHolder {
        TextView txtSet;
        public FlashCardViewHolder(View view) {
            super(view);
            txtSet = view.findViewById(R.id.idSetName);
        }
    }
}
