package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class RyanPetitionsApplication {

	@Autowired
	private PetitionService petitionService;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/hello")
	public String hello2() {
		return "Hello there";
	}

	public static void main(String[] args) {
		SpringApplication.run(RyanPetitionsApplication.class, args);
	}

}
