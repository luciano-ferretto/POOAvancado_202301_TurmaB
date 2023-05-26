package br.edu.atitus.pooavancado.CadUsuario.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.pooavancado.CadUsuario.entities.Produto;
import br.edu.atitus.pooavancado.CadUsuario.services.GenericService;
import br.edu.atitus.pooavancado.CadUsuario.services.ProdutoService;


@RestController
@RequestMapping("/produtos")
public class ProdutoController extends GenericController<Produto>{

	final ProdutoService produtoService;
	public ProdutoController(ProdutoService produtoService) {
		super();
		this.produtoService = produtoService;
	}


	@Override
	GenericService<Produto> getService() {
		return produtoService;
	}

}
