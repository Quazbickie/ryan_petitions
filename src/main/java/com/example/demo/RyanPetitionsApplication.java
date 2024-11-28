package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RyanPetitionsApplication {

	@RequestMapping("/")
	public String hello1() {
		return "Please work";
	}

	@RequestMapping("/hello")
	public String hello2() {
		return "Hello there";
	}

	public static void main(String[] args) {
		SpringApplication.run(RyanPetitionsApplication.class, args);
	}

}
