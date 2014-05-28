package br.com.unopar.delivery.repository.impl;

import org.springframework.stereotype.Repository;

import br.com.unopar.delivery.model.Endereco;
import br.com.unopar.delivery.repository.EnderecoRepository;

@Repository
public class EnderecoRespositoryImpl extends GenericRepositoryImpl<Endereco> implements EnderecoRepository {
	
	public EnderecoRespositoryImpl() {
		super();
		this.persistentClass = Endereco.class;
	}

}
