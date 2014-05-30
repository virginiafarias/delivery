package br.com.unopar.delivery.repository;

import java.util.List;

import br.com.unopar.delivery.model.Usuario;

public interface UsuarioRespository extends GenericRepository<Usuario> {
	
	public List<Usuario> getUsuarioByLogin(String login, String senha);

}
