package br.com.unopar.delivery.repository;

import java.util.List;

import br.com.unopar.delivery.model.Pedido;

public interface PedidoRepository extends GenericRepository<Pedido> {
	
	public List<Pedido> listar();

	public Pedido getById(Integer id);

}
