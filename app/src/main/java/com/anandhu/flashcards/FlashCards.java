package com.anandhu.flashcards;

import java.io.Serializable;

public class FlashCards implements Serializable{
    public String set;
    public String meaning;

    public FlashCards(String set){
        this.set = set;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

}
