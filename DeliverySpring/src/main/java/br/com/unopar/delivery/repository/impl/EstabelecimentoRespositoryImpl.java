package br.com.unopar.delivery.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.unopar.delivery.model.Estabelecimento;
import br.com.unopar.delivery.repository.EstabelecimentoRepository;

@Repository
public class EstabelecimentoRespositoryImpl extends GenericRepositoryImpl<Estabelecimento> implements EstabelecimentoRepository {
	
	public EstabelecimentoRespositoryImpl() {
		super();
		this.persistentClass = Estabelecimento.class;
	}

	@Override
	public Estabelecimento getByUsuarioId(Integer id) {
		List<Estabelecimento> result = em.createQuery("select e from Estabelecimento e where e.usuario.id = :id", Estabelecimento.class).getResultList();
		if (result != null && !result.isEmpty()) {
			return result.get(0);
		}
		return null;
	}

}
