package br.edu.atitus.pooavancado.CadUsuario.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.atitus.pooavancado.CadUsuario.entities.Departamento;
import br.edu.atitus.pooavancado.CadUsuario.entities.Usuario;
import br.edu.atitus.pooavancado.CadUsuario.repositories.DepartamentoRepository;
import br.edu.atitus.pooavancado.CadUsuario.services.DepartamentoService;
import br.edu.atitus.pooavancado.CadUsuario.services.UsuarioService;

@Service
public class DepartamentoServiceImpl implements DepartamentoService{

	final DepartamentoRepository departamentoRepository;
	public DepartamentoServiceImpl(DepartamentoRepository departamentoRepository) {
		super();
		this.departamentoRepository = departamentoRepository;
	}

	@Override
	public DepartamentoRepository getRepository() {
		return departamentoRepository;
	}

	@Override
	public void validateSave(Departamento objeto) throws Exception {
		DepartamentoService.super.validateSave(objeto);
		Usuario usuarioLogado  = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (usuarioLogado.getDepartamento().getId() != 1)
			throw new Exception("Você não tem permissão");
	}
	
	
}
