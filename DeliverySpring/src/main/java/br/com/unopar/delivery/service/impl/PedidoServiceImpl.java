package br.com.unopar.delivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unopar.delivery.model.Pedido;
import br.com.unopar.delivery.model.PedidoProduto;
import br.com.unopar.delivery.repository.PedidoProdutoRepository;
import br.com.unopar.delivery.repository.PedidoRepository;
import br.com.unopar.delivery.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PedidoProdutoRepository pedidoProdutoRepository;

	@Override
	public List<Pedido> listar() {
		return pedidoRepository.listar();
	}

	@Override
	public Pedido cadastrar(Pedido pedido) {
		return pedidoRepository.adicionarOuAtualizar(pedido);
	}

	@Override
	public Pedido getById(Integer id) {
		return pedidoRepository.getById(id);
	}

	@Override
	public PedidoProduto cadastrar(PedidoProduto pedidoProduto) {
		return pedidoProdutoRepository.adicionarOuAtualizar(pedidoProduto);
	}

}
