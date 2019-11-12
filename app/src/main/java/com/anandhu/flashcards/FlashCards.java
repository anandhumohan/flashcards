package com.anandhu.flashcards;

import java.io.Serializable;

public class FlashCards implements Serializable{
    public String set;

    public FlashCards(String set){
        this.set = set;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

}
