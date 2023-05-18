package br.edu.atitus.pooavancado.CadUsuario.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import br.edu.atitus.pooavancado.CadUsuario.entities.GenericEntity;

@NoRepositoryBean
public interface GenericRepository<TEntidade extends GenericEntity> extends JpaRepository<TEntidade, Long>{
	
	Page<TEntidade> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
	
	boolean existsByNomeAndIdNot(String nome, long id);
	
	Page<TEntidade> findByNome(String nome, Pageable pageable);

}
