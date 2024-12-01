package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PetitionService {
    public final List<Petition> petitions = new ArrayList<>(); // ArrayList of to store all petitions

    public PetitionService(){
        petitions.add(new Petition("Save the turtles", "Petition to save the turtles")); // Dummy values
        petitions.add(new Petition("Save the rainforest", "Petition to save the rainforest")); // Dummy values
        petitions.add(new Petition("Save the planet", "Petition to save the planet")); // Dummy values
    }

    // Method to add petition to the arraylist
    public void addPetition(Petition petition){
        petitions.add(petition);
    }

    // return all petitions
    public List<Petition> getPetitions(){
        return petitions;
    }

    // Search petitions by checking each petition and collecting them if they contain search query
    public List<Petition> searchPetitions(String search){
        List<Petition> searchResults = new ArrayList<>();
        for(Petition p : petitions){
            if(p.getTitle().toLowerCase().contains(search.toLowerCase())){
                searchResults.add(p);
            }
        }
        return searchResults;
    }

    // Return the petition by ID
    public Petition getPetitionByID(int ID){
        for(Petition p : petitions){
            if(p.getID() == ID){
                return p;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        String ret = "";
        for (Petition p : petitions) {
            ret += p.getID() + ") " + p.getTitle() + ": " + p.getDescription() + "\n";
        }
        return ret;
    }
}
