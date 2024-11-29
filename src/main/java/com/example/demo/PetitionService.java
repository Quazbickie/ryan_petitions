package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PetitionService {
    public final List<Petition> petitions = new ArrayList<>();

    public void addPetition(Petition petition){
        petitions.add(petition);
    }

    public List<Petition> getPetitions(){
        return petitions;
    }

    public List<Petition> searchPetitions(String search){
        List<Petition> searchResults = new ArrayList<>();
        for(Petition p : petitions){
            if(p.getTitle().toLowerCase().contains(search.toLowerCase()));{
                searchResults.add(p);
            }
        }
        return searchResults;
    }




}
