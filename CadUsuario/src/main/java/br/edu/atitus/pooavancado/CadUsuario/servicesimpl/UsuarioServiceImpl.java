package br.edu.atitus.pooavancado.CadUsuario.servicesimpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.atitus.pooavancado.CadUsuario.entities.Usuario;
import br.edu.atitus.pooavancado.CadUsuario.repositories.UsuarioRepository;
import br.edu.atitus.pooavancado.CadUsuario.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	final UsuarioRepository usuarioRepository;
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}
	
	@Override
	public void validateSave(Usuario objeto) throws Exception {
		UsuarioService.super.validateSave(objeto);
		if (objeto.getEmail() == null || objeto.getEmail().isEmpty())
			throw new Exception("É necessário informar um e-mail válido");
		if (getRepository().existsByEmailAndIdNot(objeto.getEmail(), objeto.getId()))
			throw new Exception("Já existe usuário com este e-mail!");
	}

	@Override
	public UsuarioRepository getRepository() {
		return usuarioRepository;
	}
	@Override
	@Transactional
	public void alteraStatus(long id) throws Exception {
		if (!usuarioRepository.existsById(id))
			throw new Exception("Não existe usuário com o Id: " + id);
		usuarioRepository.alteraStatus(id);
	}


}
