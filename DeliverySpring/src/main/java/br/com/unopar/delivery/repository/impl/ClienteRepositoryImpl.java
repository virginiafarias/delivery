package br.com.unopar.delivery.repository.impl;

import org.springframework.stereotype.Repository;

import br.com.unopar.delivery.model.Cliente;
import br.com.unopar.delivery.repository.ClienteRepository;

@Repository
public class ClienteRepositoryImpl extends GenericRepositoryImpl<Cliente> implements ClienteRepository{
	
	public ClienteRepositoryImpl() {
		super();
		this.persistentClass = Cliente.class;
	}

}
