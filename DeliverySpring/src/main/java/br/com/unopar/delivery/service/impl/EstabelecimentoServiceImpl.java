package br.com.unopar.delivery.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unopar.delivery.model.Estabelecimento;
import br.com.unopar.delivery.repository.EnderecoRepository;
import br.com.unopar.delivery.repository.EstabelecimentoRepository;
import br.com.unopar.delivery.repository.UsuarioRespository;
import br.com.unopar.delivery.service.EstabelecimentoService;

@Service
public class EstabelecimentoServiceImpl implements EstabelecimentoService {

	@Autowired
	private EstabelecimentoRepository estabelecimentoRespository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private UsuarioRespository usuarioRespository;
	
	@Override
	public void cadastrar(Estabelecimento estabelecimento) {
		estabelecimento.setEndereco(enderecoRepository.adicionarOuAtualizar(estabelecimento.getEndereco()));
		estabelecimento.setUsuario(usuarioRespository.adicionarOuAtualizar(estabelecimento.getUsuario()));
		estabelecimentoRespository.adicionarOuAtualizar(estabelecimento);
		
	}

}
