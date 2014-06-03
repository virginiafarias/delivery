package br.com.unopar.delivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unopar.delivery.model.Estabelecimento;
import br.com.unopar.delivery.repository.EnderecoRepository;
import br.com.unopar.delivery.repository.EstabelecimentoRepository;
import br.com.unopar.delivery.repository.UsuarioRespository;
import br.com.unopar.delivery.service.EstabelecimentoService;
import br.com.unopar.delivery.util.Role;

@Service
public class EstabelecimentoServiceImpl implements EstabelecimentoService {

	@Autowired
	private EstabelecimentoRepository estabelecimentoRespository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private UsuarioRespository usuarioRespository;
	
	@Override
	public Estabelecimento cadastrar(Estabelecimento estabelecimento) {
		estabelecimento.getUsuario().setRole(Role.ESTABELECIMENTO);
		estabelecimento.setEndereco(enderecoRepository.adicionarOuAtualizar(estabelecimento.getEndereco()));
		estabelecimento.setUsuario(usuarioRespository.adicionarOuAtualizar(estabelecimento.getUsuario()));
		return estabelecimentoRespository.adicionarOuAtualizar(estabelecimento);
		
	}

	@Override
	public Estabelecimento getByUsuarioId(Integer id) {
		return estabelecimentoRespository.getByUsuarioId(id);
	}

	@Override
	public List<Estabelecimento> getAll() {
		return estabelecimentoRespository.getAll();
	}

	@Override
	public Estabelecimento getById(Integer id) {
		return estabelecimentoRespository.getById(id);
	}

}
