package br.com.unopar.delivery.repository;

import br.com.unopar.delivery.model.Estabelecimento;

public interface EstabelecimentoRepository extends GenericRepository<Estabelecimento> {
	
	public abstract Estabelecimento getByUsuarioId(Integer id);

}
