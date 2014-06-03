package br.com.unopar.delivery.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.unopar.delivery.model.Pedido;
import br.com.unopar.delivery.repository.PedidoRepository;

@Repository
public class PedidoRepositoryImpl extends GenericRepositoryImpl<Pedido> implements PedidoRepository {
	
	public PedidoRepositoryImpl() {
		super();
		this.persistentClass = Pedido.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pedido> listar() {
		return em.createQuery("select p from Pedido p order by p.id").getResultList();
	}

	@Override
	public Pedido getById(Integer id) {
		List<Pedido> result = em.createQuery("select p from Pedido p where p.id = :id", Pedido.class).setParameter("id", id).getResultList();
		if (result != null && !result.isEmpty()) {
			return result.get(0);
		}
		return null;
	}

}
