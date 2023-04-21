package br.edu.atitus.pooavancado.CadUsuario.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.atitus.pooavancado.CadUsuario.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Page<Usuario> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
	
	boolean existsByNomeAndIdNot(String nome, long id);
	
	@Query(value = "UPDATE usuario set status = not status where id = :id", nativeQuery = true)
	@Modifying
	@Transactional
	void alteraStatus(@Param("id") long id);

}
