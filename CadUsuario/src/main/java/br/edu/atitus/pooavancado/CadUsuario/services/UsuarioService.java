package br.edu.atitus.pooavancado.CadUsuario.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetailsService;

import br.edu.atitus.pooavancado.CadUsuario.entities.Usuario;
import br.edu.atitus.pooavancado.CadUsuario.repositories.UsuarioRepository;

public interface UsuarioService extends GenericService<Usuario>, UserDetailsService{
	
	void alteraStatus(@Param("id") long id) throws Exception;

}
