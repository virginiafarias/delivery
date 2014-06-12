package br.com.unopar.delivery.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.unopar.delivery.util.Categoria;

@Entity
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Campo obrigatório")
	private String nome;
	
	@NotNull(message= "Campo obrigatório")
	private Double preco;
	
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
	@ManyToOne
	private Estabelecimento estabelecimento;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "produto")
	private List<PedidoProduto> pp;

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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	
	public List<PedidoProduto> getPp() {
		return pp;
	}

	public void setPp(List<PedidoProduto> pp) {
		this.pp = pp;
	}

	@Override
	public boolean equals(Object obj) {
		if (((Produto)obj).getId().equals(id)) {
			return true;
		}
		return false;
	}

}
