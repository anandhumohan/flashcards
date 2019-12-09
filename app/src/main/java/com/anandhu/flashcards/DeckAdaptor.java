package com.anandhu.flashcards;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class DeckAdaptor extends RecyclerView.Adapter<DeckAdaptor.FlashCardViewHolder>{
    private List<FlashCards> flashCardsList;
    private FlashCards flashCards;
    Context context;

    public DeckAdaptor(List<FlashCards> flashCardsList, Context context) {
        this.flashCardsList = flashCardsList;
        this.context = context;
    }

    @Override
    public FlashCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View FlashCardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_deck, parent, false);
        FlashCardViewHolder gvh = new FlashCardViewHolder(FlashCardView);
        return gvh;
    }

    @Override
    public void onBindViewHolder(FlashCardViewHolder holder, final int position) {
        holder.txtSet.setText(flashCardsList.get(position).getSet());
        flashCards = flashCardsList.get(position);

        holder.txtSet.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(context, CardActivity.class);
                    Integer id = position;
                    intent.putExtra("key", (id+1));
                    context.startActivity(intent);
                }catch (Exception e){

                }
            }
        });
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
