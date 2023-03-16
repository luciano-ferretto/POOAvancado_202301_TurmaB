package br.edu.atitus.pooavancado.CadUsuario.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
@CrossOrigin(origins = "*")
public class StatusController {
	
	@GetMapping
	public ResponseEntity<Object> getStatus() {
		return ResponseEntity.status(HttpStatus.CREATED).body("Hello World!!!");
	}

}
