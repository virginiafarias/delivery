package br.com.unopar.delivery.repository.impl;

import org.springframework.stereotype.Repository;

import br.com.unopar.delivery.model.PedidoProduto;
import br.com.unopar.delivery.repository.PedidoProdutoRepository;

@Repository
public class PedidoProdutoRepositoryImpl extends GenericRepositoryImpl<PedidoProduto> implements PedidoProdutoRepository {
	
	public PedidoProdutoRepositoryImpl() {
		super();
		this.persistentClass = PedidoProduto.class;
	}

}
