package com.anandhu.flashcards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private DeckAdaptor fAdapter;
    private List<FlashCards> setList;
    private DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataBaseHelper = new DataBaseHelper(this);
        dataBaseHelper.createDeck(this);
        dataBaseHelper.createCard(this);
        List<String> deckList = (List<String>) dataBaseHelper.getAllDecks();

        //getting the recyclerview from xml
        mRecyclerView = (RecyclerView) findViewById(R.id.idRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        setList = new ArrayList<>();
        for(int i = 0; i < deckList.size(); i++){
            setList.add(new FlashCards(deckList.get(i)));
        }

        //set adapter to recyclerview
        fAdapter = new DeckAdaptor(setList,this);
        mRecyclerView.setAdapter(fAdapter);
    }
}
