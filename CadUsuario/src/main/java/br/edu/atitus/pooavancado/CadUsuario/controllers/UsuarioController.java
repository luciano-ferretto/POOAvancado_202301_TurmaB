package br.edu.atitus.pooavancado.CadUsuario.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
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
import br.edu.atitus.pooavancado.CadUsuario.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {
	
	final UsuarioService usuarioService;
	
	public UsuarioController(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}

	@PostMapping
	public ResponseEntity<Object> postUsuarios(@RequestBody Usuario usuario){
		try {
			usuarioService.save(usuario);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
	}
	
	@GetMapping
	public ResponseEntity<Object> getUsuarios(@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable paginacao,  
			@RequestParam(required = false) String nome, @RequestParam(required = false) String email){
		try {
			Page<Usuario> lista = usuarioService.findByNome(nome, paginacao);
			return ResponseEntity.status(HttpStatus.OK).body(lista);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getUsuarioById(@PathVariable long id){
		Usuario usuario;
		try {
			usuario = this.usuarioService.findById(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(usuario);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> putUsuario(@PathVariable long id, @RequestBody Usuario usuario){
		usuario.setId(id);
		try {
			usuarioService.save(usuario);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(usuario);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUsuario(@PathVariable long id) {
		try {
			usuarioService.deleteById(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
	}
	
	@PatchMapping("/status/{id}")
	public ResponseEntity<Object> alteraStatus(@PathVariable long id){
		try {
			usuarioService.alteraStatus(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(id);
	}
	
	
	
	
	
	
	
	

}
