package br.com.unopar.delivery.repository;

import java.util.List;

import br.com.unopar.delivery.model.Estabelecimento;

public interface EstabelecimentoRepository extends GenericRepository<Estabelecimento> {
	
	public abstract Estabelecimento getByUsuarioId(Integer id);

	public abstract List<Estabelecimento> getAll();

	public abstract Estabelecimento getById(Integer id);

}
