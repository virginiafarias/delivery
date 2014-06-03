package br.com.unopar.delivery.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PedidoProdutoPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer idPedido;

	private Integer idProduto;

	

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idProduto;
		result = prime * result + idPedido;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoProdutoPK other = (PedidoProdutoPK) obj;
		if (idProduto != other.idProduto)
			return false;
		if (idPedido != other.idPedido)
			return false;
		return true;
	}

}
