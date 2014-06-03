package br.com.unopar.delivery.service;

import java.util.List;

import br.com.unopar.delivery.model.Pedido;
import br.com.unopar.delivery.model.PedidoProduto;

public interface PedidoService {
	
	public abstract List<Pedido> listar();
	
	public abstract Pedido cadastrar(Pedido Pedido);

	public abstract Pedido getById(Integer id);
	
	public abstract PedidoProduto cadastrar(PedidoProduto pedidoProduto);

}
