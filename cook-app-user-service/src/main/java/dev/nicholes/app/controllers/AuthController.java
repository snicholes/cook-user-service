package dev.nicholes.app.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.nicholes.app.beans.Person;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@PostMapping
	public ResponseEntity<String> getToken() {
		return null;
	}
	
	@GetMapping
	public ResponseEntity<Person> getUserWithToken() {
		return null;
	}
	
}
