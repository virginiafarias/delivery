package br.com.unopar.delivery.model;

import java.io.Serializable;

public class Estabelecimento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String nome;
	
	private Endereco endereco;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	

}
