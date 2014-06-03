package br.com.unopar.delivery.service;

import br.com.unopar.delivery.model.Cliente;

public interface ClienteService {
	
	public abstract Cliente cadastrar(Cliente cliente);

	public abstract Cliente getByUsuarioId(Integer id);
	
	public abstract Cliente getById(Integer id);

}
