package com.anandhu.flashcards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

public class CardActivity extends AppCompatActivity{
    private RecyclerView mRecyclerView;
    private CardAdaptor fAdapter;
    private List<Card> setList;
    private DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Intent intent = getIntent();
            int value = intent.getIntExtra("key",0);

            dataBaseHelper = new DataBaseHelper(this);
            List<Card> deckList = (List<Card>) dataBaseHelper.getAllCardsWithDeckId(value);

            //getting the recyclerview from xml
            mRecyclerView = (RecyclerView) findViewById(R.id.idRecyclerView);
            //mRecyclerView.setHasFixedSize(true);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


            setList = new ArrayList<Card>();
            Card ca = null;
            for(int i = 0; i < deckList.size(); i++){
                ca = new Card();
                ca.setWord(deckList.get(i).getWord());
                ca.setMeaning(deckList.get(i).getMeaning());
                setList.add(ca);
            }

            //set adapter to recyclerview
            fAdapter = new CardAdaptor(setList, this);
            mRecyclerView.setAdapter(fAdapter);
        }catch (Exception e){

        }
    }
}
