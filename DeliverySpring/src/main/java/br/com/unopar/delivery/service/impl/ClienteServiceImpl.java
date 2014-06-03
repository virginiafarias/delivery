package br.com.unopar.delivery.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unopar.delivery.model.Cliente;
import br.com.unopar.delivery.repository.ClienteRepository;
import br.com.unopar.delivery.repository.EnderecoRepository;
import br.com.unopar.delivery.repository.UsuarioRespository;
import br.com.unopar.delivery.service.ClienteService;
import br.com.unopar.delivery.util.Role;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired UsuarioRespository usuarioRespository;

	@Override
	public Cliente cadastrar(Cliente cliente) {
		cliente.getUsuario().setRole(Role.CLIENTE);
		cliente.setEndereco(enderecoRepository.adicionarOuAtualizar(cliente.getEndereco()));
		cliente.setUsuario(usuarioRespository.adicionarOuAtualizar(cliente.getUsuario()));
		
		return clienteRepository.adicionarOuAtualizar(cliente);
		
	}

	@Override
	public Cliente getByUsuarioId(Integer id) {
		return clienteRepository.getByUsuarioId(id);
	}

	@Override
	public Cliente getById(Integer id) {
		return clienteRepository.getById(id);
	}

}
