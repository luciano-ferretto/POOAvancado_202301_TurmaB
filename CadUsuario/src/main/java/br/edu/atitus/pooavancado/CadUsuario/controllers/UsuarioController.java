package br.edu.atitus.pooavancado.CadUsuario.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.pooavancado.CadUsuario.entities.Usuario;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {
	
	private List<Usuario> listaUsuarios = new ArrayList<>();
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUsuario(@PathVariable long id) {
		return ResponseEntity.status(HttpStatus.OK).body(id);
	}
	
	@PatchMapping("/status/{id}")
	public ResponseEntity<Object> alteraStatus(@PathVariable long id){
		return ResponseEntity.status(HttpStatus.OK).body(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> putUsuario(@PathVariable long id, @RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.OK).body(id);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getUsuarioById(@PathVariable long id){
		for (Usuario usuario : listaUsuarios) {
			if (usuario.getId() == id)
				return ResponseEntity.status(HttpStatus.OK).body(usuario);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe usuário ID " + id);
	}
	
	@GetMapping
	public ResponseEntity<Object> getUsuarios(@RequestParam(required = false) String nome, @RequestParam(required = false) String email){
		System.out.println("Nome pesquisado: " + nome);
		System.out.println("Email pesquisado: " + email);
		return ResponseEntity.status(HttpStatus.OK).body(listaUsuarios);
	}
	
	@PostMapping
	public ResponseEntity<Object> postUsuarios(@RequestBody Usuario usuario){
		listaUsuarios.add(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
	}

}
