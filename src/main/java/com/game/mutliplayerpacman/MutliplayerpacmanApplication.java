package com.game.mutliplayerpacman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MutliplayerpacmanApplication {

	public static void main(String[] args) {
		SpringApplication.run(MutliplayerpacmanApplication.class, args);
	}

	@GetMapping("/")
	public String greeting() {
		return "hello world";
	}

}
