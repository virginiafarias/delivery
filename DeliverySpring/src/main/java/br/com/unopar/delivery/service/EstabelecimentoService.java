package br.com.unopar.delivery.service;

import br.com.unopar.delivery.model.Estabelecimento;

public interface EstabelecimentoService {
	
	public abstract Estabelecimento cadastrar(Estabelecimento estabelecimento);
	
	public abstract Estabelecimento getByUsuarioId(Integer id);

}
