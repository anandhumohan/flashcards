package com.anandhu.flashcards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.anandhu.flashcards.FlashCardAdaptor;
import com.anandhu.flashcards.FlashCards;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private FlashCardAdaptor fAdapter;
    private List<FlashCards> setList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getting the recyclerview from xml
        mRecyclerView = (RecyclerView) findViewById(R.id.idRecyclerView);
        //mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Populate the products
        setList = new ArrayList<>();
        setList.add(new FlashCards("Flash car set 1"));
        setList.add(new FlashCards("Flash car set 2"));
        setList.add(new FlashCards("Flash car set 3"));
        setList.add(new FlashCards("Flash car set 4"));
        setList.add(new FlashCards("Flash car set 5"));
        setList.add(new FlashCards("Flash car set 6"));
        setList.add(new FlashCards("Flash car set 7"));
        setList.add(new FlashCards("Flash car set 8"));
        setList.add(new FlashCards("Flash car set 9"));
        setList.add(new FlashCards("Flash car set 10"));




        //set adapter to recyclerview
        fAdapter = new FlashCardAdaptor(setList,this);
        mRecyclerView.setAdapter(fAdapter);
    }
}
