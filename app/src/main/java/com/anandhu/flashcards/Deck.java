package com.anandhu.flashcards;

public class Deck{
    public Integer Id;
    public String Name;
    public String Is_completed;


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getIs_completed() {
        return Is_completed;
    }

    public void setIs_completed(String is_completed) {
        Is_completed = is_completed;
    }
}
