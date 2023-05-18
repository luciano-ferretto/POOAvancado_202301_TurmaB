package br.edu.atitus.pooavancado.CadUsuario.servicesimpl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.atitus.pooavancado.CadUsuario.entities.Departamento;
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
	@Transactional
	public Departamento save(Departamento departamento) throws Exception {
		if (departamentoRepository.existsByNomeAndIdNot(departamento.getNome(), departamento.getId()))
			throw new Exception("Já existe departamento com este nome!");
		return this.departamentoRepository.save(departamento);
	}


	@Override
	public Departamento findById(long id) throws Exception {
		var departamento = this.departamentoRepository.findById(id);
		if (departamento.isEmpty())
			throw new Exception("Não existe usuário com Id: " + id);
		return departamento.get();
	}


	@Override
	public Page<Departamento> findByNome(String nome, Pageable pageable) throws Exception{
		return this.departamentoRepository.findByNomeContainingIgnoreCase(nome, pageable);
	}


	@Override
	@Transactional
	public void deleteById(long id) throws Exception {
		if (!departamentoRepository.existsById(id))
			throw new Exception("Não existe usuário com o Id: " + id);
		departamentoRepository.deleteById(id);
	}

}
