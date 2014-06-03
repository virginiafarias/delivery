package br.com.unopar.delivery.repository;

import br.com.unopar.delivery.model.Cliente;

public interface ClienteRepository extends GenericRepository<Cliente> {

	public abstract Cliente getByUsuarioId(Integer id);
	public abstract Cliente getById(Integer id);
	

}
