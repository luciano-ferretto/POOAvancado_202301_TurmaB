package br.edu.atitus.pooavancado.CadUsuario.servicesimpl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
	public Usuario save(Usuario usuario) throws Exception {
		if (usuarioRepository.existsByNomeAndIdNot(usuario.getNome(), usuario.getId()))
			throw new Exception("Já existe usuário com este nome!");
		return this.usuarioRepository.save(usuario);
	}


	@Override
	public Usuario findById(long id) throws Exception {
		var usuario = this.usuarioRepository.findById(id);
		if (usuario.isEmpty())
			throw new Exception("Não existe usuário com Id: " + id);
		return usuario.get();
	}


	@Override
	public Page<Usuario> findByNome(String nome, Pageable pageable) throws Exception{
		return this.usuarioRepository.findByNomeContainingIgnoreCase(nome, pageable);
	}


	@Override
	public void deleteById(long id) throws Exception {
		if (!usuarioRepository.existsById(id))
			throw new Exception("Não existe usuário com o Id: " + id);
		usuarioRepository.deleteById(id);
	}


	@Override
	public void alteraStatus(long id) throws Exception {
		if (!usuarioRepository.existsById(id))
			throw new Exception("Não existe usuário com o Id: " + id);
		usuarioRepository.alteraStatus(id);
	}

}
