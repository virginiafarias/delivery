package br.com.unopar.delivery.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.unopar.delivery.model.Produto;
import br.com.unopar.delivery.repository.ProdutoRepository;

@Repository
public class ProdutoRespositoryImpl extends GenericRepositoryImpl<Produto> implements ProdutoRepository {
	
	public ProdutoRespositoryImpl() {
		super();
		this.persistentClass = Produto.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> listar() {
		return em.createQuery("select c from Produto c order by c.id").getResultList();
	}

}
