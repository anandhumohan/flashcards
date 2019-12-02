package com.anandhu.flashcards;

public class Card{
    public Integer id;
    public String word;
    public String meanig;
    public String deckId;
    public String is_completed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeanig() {
        return meanig;
    }

    public void setMeanig(String meanig) {
        this.meanig = meanig;
    }

    public String getDeckId() {
        return deckId;
    }

    public void setDeckId(String deckId) {
        this.deckId = deckId;
    }

    public String getIs_completed() {
        return is_completed;
    }

    public void setIs_completed(String is_completed) {
        this.is_completed = is_completed;
    }
}
