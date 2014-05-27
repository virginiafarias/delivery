package br.com.unopar.delivery.repository;

import java.util.List;

import br.com.unopar.delivery.model.Produto;


public interface ProdutoRepository {
	
	public List<Produto> listar();

}
