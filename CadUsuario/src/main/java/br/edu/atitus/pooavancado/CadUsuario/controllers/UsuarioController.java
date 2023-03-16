package br.edu.atitus.pooavancado.CadUsuario.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.pooavancado.CadUsuario.entities.Usuario;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {
	
	private List<Usuario> listaUsuarios = new ArrayList<>();
	
	@GetMapping
	public ResponseEntity<Object> getUsuarios(){
		return ResponseEntity.status(HttpStatus.OK).body(listaUsuarios);
	}
	
	@PostMapping
	public ResponseEntity<Object> postUsuarios(@RequestBody Usuario usuario){
		listaUsuarios.add(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
	}

}
