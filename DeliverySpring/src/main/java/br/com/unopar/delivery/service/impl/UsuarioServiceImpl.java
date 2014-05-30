package br.com.unopar.delivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unopar.delivery.model.Usuario;
import br.com.unopar.delivery.repository.UsuarioRespository;
import br.com.unopar.delivery.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRespository usuarioRespository;

	@Override
	public List<Usuario> getUsuarioByLogin(String login, String senha) {
		return usuarioRespository.getUsuarioByLogin(login, senha);
	}

}
