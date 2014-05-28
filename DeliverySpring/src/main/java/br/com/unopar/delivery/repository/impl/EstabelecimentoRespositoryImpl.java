package br.com.unopar.delivery.repository.impl;

import org.springframework.stereotype.Repository;

import br.com.unopar.delivery.model.Estabelecimento;
import br.com.unopar.delivery.repository.EstabelecimentoRepository;

@Repository
public class EstabelecimentoRespositoryImpl extends GenericRepositoryImpl<Estabelecimento> implements EstabelecimentoRepository {
	
	public EstabelecimentoRespositoryImpl() {
		super();
		this.persistentClass = Estabelecimento.class;
	}

}
