package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Petition {

    private static int ID = 1;
    private String title;
    private String description;
    private List<String> signatures = new ArrayList<>();

    public Petition(int ID, String title, String description){
        this.ID = ID++;
        this.title = title;
        this.description = description;
    }

    public void addSignature(String name){
        signatures.add(name);
    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getSignatures() {
        return signatures;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

}
