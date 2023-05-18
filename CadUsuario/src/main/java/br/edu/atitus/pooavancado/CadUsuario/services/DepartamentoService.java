package br.edu.atitus.pooavancado.CadUsuario.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import br.edu.atitus.pooavancado.CadUsuario.entities.Departamento;
import br.edu.atitus.pooavancado.CadUsuario.repositories.DepartamentoRepository;

public interface DepartamentoService extends GenericService<Departamento, DepartamentoRepository>{
	
	
}
