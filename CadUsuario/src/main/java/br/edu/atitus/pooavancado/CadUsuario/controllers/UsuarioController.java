package br.edu.atitus.pooavancado.CadUsuario.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import br.edu.atitus.pooavancado.CadUsuario.repositories.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private List<Usuario> listaUsuarios = new ArrayList<>();
	
	@PostMapping
	public ResponseEntity<Object> postUsuarios(@RequestBody Usuario usuario){
		usuarioRepository.save(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
	}
	
	@GetMapping
	public ResponseEntity<Object> getUsuarios(@RequestParam(required = false) String nome, @RequestParam(required = false) String email){
		List<Usuario> lista = usuarioRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getUsuarioById(@PathVariable long id){
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if (usuario.isPresent())
			return ResponseEntity.status(HttpStatus.OK).body(usuario);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe usuário ID " + id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> putUsuario(@PathVariable long id, @RequestBody Usuario usuario){
		usuario.setId(id);
		usuarioRepository.save(usuario);
		return ResponseEntity.status(HttpStatus.OK).body(usuario);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUsuario(@PathVariable long id) {
		usuarioRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
	}
	
	@PatchMapping("/status/{id}")
	public ResponseEntity<Object> alteraStatus(@PathVariable long id){
		return ResponseEntity.status(HttpStatus.OK).body(id);
	}
	
	
	
	
	
	
	
	

}
