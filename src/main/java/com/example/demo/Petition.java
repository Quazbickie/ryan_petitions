package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Petition {

    private static int counter = 1; //static counter that is shared for all instances of petition.
    private int ID;
    private String title;
    private String description;
    private List<String> signatures = new ArrayList<>();

    public Petition(String title, String description){
        this.ID = counter++; //increment counter for next petition
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

}
