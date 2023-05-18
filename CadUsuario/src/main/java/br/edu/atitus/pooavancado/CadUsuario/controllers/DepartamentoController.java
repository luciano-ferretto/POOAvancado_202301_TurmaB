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

import br.edu.atitus.pooavancado.CadUsuario.entities.Departamento;
import br.edu.atitus.pooavancado.CadUsuario.services.DepartamentoService;

@RestController
@RequestMapping("/departamentos")
@CrossOrigin(origins = "*")
public class DepartamentoController {
	
	final DepartamentoService departamentoService;
	
	public DepartamentoController(DepartamentoService departamentoService) {
		super();
		this.departamentoService = departamentoService;
	}

	@PostMapping
	public ResponseEntity<Object> postDepartamentos(@RequestBody Departamento departamento){
		try {
			departamentoService.save(departamento);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(departamento);
	}
	
	@GetMapping
	public ResponseEntity<Object> getDepartamentos(@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable paginacao,  
			@RequestParam(required = false) String nome, @RequestParam(required = false) String email){
		try {
			Page<Departamento> lista = departamentoService.findByNome(nome, paginacao);
			return ResponseEntity.status(HttpStatus.OK).body(lista);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getDepartamentoById(@PathVariable long id){
		Departamento departamento;
		try {
			departamento = this.departamentoService.findById(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(departamento);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> putDepartamento(@PathVariable long id, @RequestBody Departamento departamento){
		departamento.setId(id);
		try {
			departamentoService.save(departamento);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(departamento);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUsuario(@PathVariable long id) {
		try {
			departamentoService.deleteById(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
	}
	
}
