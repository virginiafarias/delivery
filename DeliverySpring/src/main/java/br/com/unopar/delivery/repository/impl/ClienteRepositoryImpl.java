package br.com.unopar.delivery.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.unopar.delivery.model.Cliente;
import br.com.unopar.delivery.repository.ClienteRepository;

@Repository
public class ClienteRepositoryImpl extends GenericRepositoryImpl<Cliente> implements ClienteRepository{
	
	public ClienteRepositoryImpl() {
		super();
		this.persistentClass = Cliente.class;
	}

	@Override
	public Cliente getByUsuarioId(Integer id) {
		List<Cliente> result = em.createQuery("select c from Cliente c where c.usuario.id = :id", Cliente.class).setParameter("id", id).getResultList();
		if (result != null && !result.isEmpty()) {
			return result.get(0);
		}
		return null;
	}

	@Override
	public Cliente getById(Integer id) {
		List<Cliente> result = em.createQuery("select c from Cliente c where c.id = :id", Cliente.class).setParameter("id", id).getResultList();
		if (result != null && !result.isEmpty()) {
			return result.get(0);
		}
		return null;
	}

}
