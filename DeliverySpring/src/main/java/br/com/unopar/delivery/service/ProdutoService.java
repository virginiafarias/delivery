package br.com.unopar.delivery.service;

import java.util.List;

import br.com.unopar.delivery.model.Produto;

public interface ProdutoService {
	
	public abstract List<Produto> listar();
	
	public abstract Produto cadastrar(Produto produto);

	public abstract Produto getById(Integer id);
	
	public abstract void excluir(Integer id);

}
