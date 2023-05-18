package br.edu.atitus.pooavancado.CadUsuario.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.edu.atitus.pooavancado.CadUsuario.entities.GenericEntity;
import br.edu.atitus.pooavancado.CadUsuario.repositories.GenericRepository;

public interface GenericService<TEntidade extends GenericEntity, TRepository extends GenericRepository<TEntidade>> {
	
	TRepository getRepository();
	
	default TEntidade save(TEntidade objeto) throws Exception{
		if (getRepository().existsByNomeAndIdNot(objeto.getNome(), objeto.getId()))
			throw new Exception("Já existe usuário com este nome!");
		return this.getRepository().save(objeto);
	}
	
	default TEntidade findById(Long id) throws Exception{
		var objeto = getRepository().findById(id);
		if (objeto.isEmpty())
			throw new Exception("Não existe cadastro com o Id: " + id);
		return objeto.get();
	}
	
	default Page<TEntidade> findByNome(String nome, Pageable pageable) throws Exception{
		return getRepository().findByNomeContainingIgnoreCase(nome, pageable);
	}
	
	default void deleteById(Long id) throws Exception{
		if (getRepository().existsById(id))
			throw new Exception("Não existe usuário com o Id: " + id);
		getRepository().deleteById(id);
	}

}
