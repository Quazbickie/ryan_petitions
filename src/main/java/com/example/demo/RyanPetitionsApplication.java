package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@Controller
public class RyanPetitionsApplication {

	//Declare petitionService to enable operations such as getPetitions
	@Autowired
	private PetitionService petitionService;

	//Route for landing page
	//Get all petitions and add these to the model so the view can render this data
	@GetMapping("/")
	public String home(Model model) {
		//System.out.println(petitionService.toString()); //DEBUG - Ensure dummy values are correctly populated
		model.addAttribute("petitions", petitionService.getPetitions());
		return "home";
	}

	//Route for creating new petition
	@GetMapping("/create")
	public String showCreateForm(){
		return "create-petition";
	}

	//Post method that gets the title and description params from the HTTP request
	//creates petition based on these params and adds to the arraylist
	//redirect back to home page
	@PostMapping("/create")
	public String createPetition(@RequestParam String title, @RequestParam String description) {
		Petition p = new Petition(title, description);
		petitionService.addPetition(p);
		return "redirect:/";
	}

	//Route to handle request to view a petition by its ID at /petitions/{ID}
	//Fetches the petition by id from the arraylist
	//Add it to the model for the view-petition page to render
	@GetMapping("/petitions/{ID}")
	public String viewPetition(@PathVariable int ID, Model model) {
		model.addAttribute("petition", petitionService.getPetitionByID(ID));
		return "view-petition";
	}

	//Handle form submissions to /petitions/{ID} for signing petition
	//Get the signature name from the http request
	// get the correct petition by ID and add the signature to that petition
	//add the petition to the model and refresh the page. The view will now show updated signatures
	@PostMapping("/petitions/{ID}")
	public String signPetition(@PathVariable int ID, @RequestParam String name, Model model) {
		Petition petition = petitionService.getPetitionByID(ID);
		petition.addSignature(name);
		model.addAttribute("petition", petition);
		return "redirect:/petitions/" + ID;
	}

	//handles search queries at /search
	//use requestparam to get the search term input by user
	//get the sublist of petitions containing search term in title
	//if the list is empty add no results to model
	//other wise add search results petitions to model and go to search-results view
	@GetMapping("/search")
	public String search(@RequestParam("search") String search, Model model) {
		List<Petition> results = petitionService.searchPetitions(search);
		if (results.isEmpty()) {
			model.addAttribute("noResults", "No Results");
		} else {
			model.addAttribute("petitions", results);
		}
		return "search-results";
	}

	@RequestMapping("/hello")
	public String hello2() {
		return "Hello there";
	}

	public static void main(String[] args) {
		SpringApplication.run(RyanPetitionsApplication.class, args);
	}

}
