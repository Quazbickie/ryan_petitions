package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PetitionService {
    public final List<Petition> petitions = new ArrayList<>();

    public PetitionService(){
        petitions.add(new Petition("Save the turtles", "Petition to save the turtles")); // Dummy values
        petitions.add(new Petition("Save the rainforest", "Petition to save the rainforest")); // Dummy values
        petitions.add(new Petition("Save the planet", "Petition to save the planet")); // Dummy values
    }

    public void addPetition(Petition petition){
        petitions.add(petition);
    }

    public List<Petition> getPetitions(){
        return petitions;
    }

    public List<Petition> searchPetitions(String search){
        List<Petition> searchResults = new ArrayList<>();
        for(Petition p : petitions){
            if(p.getTitle().toLowerCase().contains(search.toLowerCase())){
                searchResults.add(p);
            }
        }
        return searchResults;
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
