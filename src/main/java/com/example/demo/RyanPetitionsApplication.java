package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@Controller
public class RyanPetitionsApplication {

	@Autowired
	private PetitionService petitionService;

	@GetMapping("/")
	public String home(Model model) {
		System.out.println(petitionService.toString()); //DEBUG
		model.addAttribute("petitions", petitionService.getPetitions());
		return "home";
	}

	@GetMapping("/create")
	public String showCreateForm(Model model){
		model.addAttribute("petition", new Petition("",""));
		return "create-petition";
	}

	@GetMapping("/petitions/{ID}")
	public String viewPetition(@PathVariable int ID, Model model) {
		model.addAttribute("petition", petitionService.getPetitionByID(ID));
		return "view-petition";
	}

	@PostMapping("/petitions/{ID}")
	public String signPetition(@PathVariable int ID, @RequestParam String name, Model model) {
		Petition petition = petitionService.getPetitionByID(ID);
		petition.addSignature(name);
		model.addAttribute("petition", petition);
		return "redirect:/petitions/" + ID;
	}

	@RequestMapping("/hello")
	public String hello2() {
		return "Hello there";
	}

	public static void main(String[] args) {
		SpringApplication.run(RyanPetitionsApplication.class, args);
	}

}
