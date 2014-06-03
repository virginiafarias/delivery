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
		return em.createQuery("select p from Produto p order by p.id").getResultList();
	}

	@Override
	public Produto getById(Integer id) {
		List<Produto> result = em.createQuery("select p from Produto p where p.id = :id", Produto.class).setParameter("id", id).getResultList();
		if (result != null && !result.isEmpty()) {
			return result.get(0);
		}
		return null;
	}

}
