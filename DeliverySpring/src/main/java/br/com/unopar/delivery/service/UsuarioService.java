package br.com.unopar.delivery.service;

import java.util.List;

import br.com.unopar.delivery.model.Usuario;

public interface UsuarioService {
	
	public abstract List<Usuario> getUsuarioByLogin(String login, String senha);

}
