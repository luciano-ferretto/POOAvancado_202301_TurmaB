package br.edu.atitus.pooavancado.CadUsuario.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.atitus.pooavancado.CadUsuario.entities.Usuario;

@Repository
public interface UsuarioRepository extends GenericRepository<Usuario>{
	
	@Query(value = "UPDATE usuario set status = not status where id = :id", nativeQuery = true)
	@Modifying
	void alteraStatus(@Param("id") long id);

}
