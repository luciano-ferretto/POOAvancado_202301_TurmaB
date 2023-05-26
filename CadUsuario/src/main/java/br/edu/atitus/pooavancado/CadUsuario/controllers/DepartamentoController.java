package br.edu.atitus.pooavancado.CadUsuario.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.pooavancado.CadUsuario.entities.Departamento;
import br.edu.atitus.pooavancado.CadUsuario.services.DepartamentoService;
import br.edu.atitus.pooavancado.CadUsuario.services.GenericService;

@RestController
@RequestMapping("/departamentos")
@CrossOrigin(origins = "*")
public class DepartamentoController extends GenericController<Departamento>{
	
	final DepartamentoService departamentoService;
	
	public DepartamentoController(DepartamentoService departamentoService) {
		super();
		this.departamentoService = departamentoService;
	}
	
	@Override
	GenericService<Departamento> getService() {
		return departamentoService;
	}
	
}
