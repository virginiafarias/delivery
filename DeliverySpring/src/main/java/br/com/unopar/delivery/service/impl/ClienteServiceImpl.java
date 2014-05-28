package br.com.unopar.delivery.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unopar.delivery.model.Cliente;
import br.com.unopar.delivery.repository.ClienteRepository;
import br.com.unopar.delivery.repository.EnderecoRepository;
import br.com.unopar.delivery.repository.UsuarioRespository;
import br.com.unopar.delivery.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired UsuarioRespository usuarioRespository;

	@Override
	public void cadastrar(Cliente cliente) {
		cliente.setEndereco(enderecoRepository.adicionarOuAtualizar(cliente.getEndereco()));
		cliente.setUsuario(usuarioRespository.adicionarOuAtualizar(cliente.getUsuario()));
		
		clienteRepository.adicionarOuAtualizar(cliente);
		
	}

}
