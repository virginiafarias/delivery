package br.com.unopar.delivery.repository.impl;

import org.springframework.stereotype.Repository;

import br.com.unopar.delivery.model.Usuario;
import br.com.unopar.delivery.repository.UsuarioRespository;

@Repository
public class UsuarioRepositoryImpl extends GenericRepositoryImpl<Usuario> implements UsuarioRespository {
	
	public UsuarioRepositoryImpl() {
		super();
		this.persistentClass = Usuario.class;
	}

}
