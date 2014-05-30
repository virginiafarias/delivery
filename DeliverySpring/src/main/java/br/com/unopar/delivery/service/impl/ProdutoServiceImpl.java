package br.com.unopar.delivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unopar.delivery.model.Produto;
import br.com.unopar.delivery.repository.ProdutoRepository;
import br.com.unopar.delivery.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public List<Produto> listar() {
		return produtoRepository.listar();
	}

	@Override
	public Produto cadastrar(Produto produto) {
		return produtoRepository.adicionarOuAtualizar(produto);
	}

}
