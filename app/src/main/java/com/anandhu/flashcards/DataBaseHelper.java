package com.anandhu.flashcards;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import android.database.SQLException;

import java.util.*;
import java.io.InputStream;
import java.io.IOException;
import android.database.Cursor;

public class DataBaseHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "flashcards.db";
    public final static String TABLE_DECK = "deck";
    public final static String TABLE_CARD = "card";
    public final static String ID = "ID";
    public final static String NAME = "NAME";
    public final static String WORD = "WORD";
    public final static String MEANING = "MEANING";
    public final static String DECK_ID = "DECK_ID";
    public final static String IS_COMPLETE = "IS_COMPLETE";

    public DataBaseHelper(Context contex) {
        super(contex, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_DECK+" ("+ID+" INTEGER PRIMARY KEY, "+NAME+" TEXT, "+IS_COMPLETE+" TEXT)";
        String CREATE_CARD="CREATE TABLE IF NOT EXISTS "+TABLE_CARD+" ("+ID+" INTEGER PRIMARY KEY, "+WORD+" TEXT, "+MEANING+" TEXT, "+IS_COMPLETE+" TEXT, "+DECK_ID+" INTEGER, FOREIGN KEY ("+DECK_ID+") REFERENCES "+TABLE_DECK+"("+ID+"))";

        db.execSQL(CREATE_TABLE);
        db.execSQL(CREATE_CARD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_DECK);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_CARD);
        onCreate(db);
    }

    public List<String> getAllDecks() {
        List<String> deckList = new ArrayList<String>();


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from deck", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            deckList.add(res.getString(res.getColumnIndex(NAME)));
            res.moveToNext();
        }
        return deckList;
    }

    public void createDeck(Context context){
        SQLiteDatabase db = this.getWritableDatabase();
        String data = getAssetJsonData(context);

        try {
            JSONArray obj = new JSONArray(data);

            for (int i = 0; i < obj.length(); i++) {
                JSONObject jsonobject = obj.getJSONObject(i);
                String name = jsonobject.getString("NAME");


                ContentValues values = new ContentValues();
                values.put("NAME", name);
                values.put("ID", i+1);
                long newRowId = db.insert(TABLE_DECK, null, values);
            }


        } catch (JSONException | SQLException e) {
            e.printStackTrace();
        }



        db.close();
    }

    public static String getAssetJsonData(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("deck.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            return null;
        }

        return json;

    }

    public void createCard(Context context){
        SQLiteDatabase db = this.getWritableDatabase();
        String data = getAssetJsonDataCard(context);

        try {
            JSONArray obj = new JSONArray(data);

            for (int i = 0; i < obj.length(); i++) {
                JSONObject jsonobject = obj.getJSONObject(i);
                String name = jsonobject.getString("WORD");
                String meaning = jsonobject.getString("MEANING");
                String deckId = jsonobject.getString("DECK_ID");


                ContentValues values = new ContentValues();
                values.put("WORD", name);
                values.put("ID", i+1);
                values.put("MEANING", meaning);
                values.put("DECK_ID", deckId);
                long newRowId = db.insert(TABLE_CARD, null, values);
            }


        } catch (JSONException | SQLException e) {
            e.printStackTrace();
        }



        db.close();
    }

    public static String getAssetJsonDataCard(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("card.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            return null;
        }

        return json;

    }

    public List<Card> getAllCardsWithDeckId(int value) {
        List<Card> deckList = new ArrayList<Card>();
        Card card = null;

        try {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor res = db.rawQuery("select * from card where DECK_ID = "+value, null);
            res.moveToFirst();

            while (res.isAfterLast() == false) {
                card = new Card();
                card.setWord(res.getString(res.getColumnIndex(WORD)));
                card.setMeaning(res.getString(res.getColumnIndex(MEANING)));
                deckList.add(card);
                res.moveToNext();
            }
        }catch(Exception e){

        }
        return deckList;
    }

}
