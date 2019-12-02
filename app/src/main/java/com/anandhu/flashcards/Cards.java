package com.anandhu.flashcards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

public class Cards extends AppCompatActivity{
    private RecyclerView mRecyclerView;
    private CardAdaptor fAdapter;
    private List<FlashCards> setList;
    private DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Intent intent = getIntent();
            int value = intent.getIntExtra("key",0);

            dataBaseHelper = new DataBaseHelper(this);
            List<String> deckList = (List<String>) dataBaseHelper.getAllCardsWithDeckId(value);

            //getting the recyclerview from xml
            mRecyclerView = (RecyclerView) findViewById(R.id.idRecyclerView);
            //mRecyclerView.setHasFixedSize(true);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


            setList = new ArrayList<>();
            for(int i = 0; i < deckList.size(); i++){
                setList.add(new FlashCards(deckList.get(i)));
            }


            //set adapter to recyclerview
            //mRecyclerView = (RecyclerView) findViewById(R.id.);
            fAdapter = new CardAdaptor(setList, this);
            mRecyclerView.setAdapter(fAdapter);
        }catch (Exception e){

        }
    }
}
