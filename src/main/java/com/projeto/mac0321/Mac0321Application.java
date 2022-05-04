package com.projeto.mac0321;

import models.TestModel;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Mac0321Application {

	public static void main(String[] args) {
		SpringApplication.run(Mac0321Application.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
	
	@GetMapping("/test")
	public ArrayList<TestModel> test() {
		ArrayList<TestModel> models = new ArrayList<>();
		models.add(new TestModel("Rodrigo", "Marcolin", 18));
		models.add(new TestModel("Nome", "Sobrenome", 20));
		models.add(new TestModel("Testêncio", "Testador", 9999));
		
		return models;
	}

}
