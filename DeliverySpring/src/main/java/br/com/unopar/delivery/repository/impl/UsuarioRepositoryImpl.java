package br.com.unopar.delivery.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.unopar.delivery.model.Usuario;
import br.com.unopar.delivery.repository.UsuarioRespository;

@Repository
public class UsuarioRepositoryImpl extends GenericRepositoryImpl<Usuario>
		implements UsuarioRespository {

	public UsuarioRepositoryImpl() {
		super();
		this.persistentClass = Usuario.class;
	}

	@Override
	public List<Usuario> getUsuarioByLogin(String login, String senha) {
		return em
				.createQuery(
						"select u from Usuario u where u.login = :login and u.senha = :senha",
						Usuario.class).setParameter("login", login)
				.setParameter("senha", senha).getResultList();
	}

}
