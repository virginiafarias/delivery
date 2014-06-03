package br.com.unopar.delivery.service;

import java.util.List;

import br.com.unopar.delivery.model.Estabelecimento;

public interface EstabelecimentoService {
	
	public abstract Estabelecimento cadastrar(Estabelecimento estabelecimento);
	
	public abstract Estabelecimento getByUsuarioId(Integer id);

	public abstract List<Estabelecimento> getAll();

	public abstract Estabelecimento getById(Integer id);

}
