package com.anandhu.flashcards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Cards extends AppCompatActivity{
    private RecyclerView mRecyclerView;
    private CardAdaptor fAdapter;
    private List<FlashCards> setList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getting the recyclerview from xml
        mRecyclerView = (RecyclerView) findViewById(R.id.idRecyclerView);
        //mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        setList = new ArrayList<>();
        setList.add(new FlashCards("Word 1"));
        setList.add(new FlashCards("Word 2"));
        setList.add(new FlashCards("Word 3"));
        setList.add(new FlashCards("Word 4"));
        setList.add(new FlashCards("Word 5"));
        setList.add(new FlashCards("Word 6"));
        setList.add(new FlashCards("Word 7"));
        setList.add(new FlashCards("Word 8"));
        setList.add(new FlashCards("Word 9"));
        setList.add(new FlashCards("Word 10"));




        //set adapter to recyclerview
        //mRecyclerView = (RecyclerView) findViewById(R.id.);
        fAdapter = new CardAdaptor(setList,this);
        mRecyclerView.setAdapter(fAdapter);
    }
}
