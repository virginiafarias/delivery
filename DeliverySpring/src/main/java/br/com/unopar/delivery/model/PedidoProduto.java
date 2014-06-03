package br.com.unopar.delivery.model;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PedidoProduto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	@AttributeOverrides( { @AttributeOverride(name = "idPedido", column =
	@Column(name = "idPedido", nullable = false)), @AttributeOverride(name =
	"idProduto", column = @Column(name = "idProduto", nullable = false)) })
	private PedidoProdutoPK id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPedido", nullable = false, insertable = false,
	updatable = false)
	private Pedido pedido;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idProduto", nullable = false, insertable = false,
	updatable = false)
	private Produto produto;
	
	private Integer quantidade;
	
	public PedidoProduto() {
		this.id =  new PedidoProdutoPK();
	}
	
	/*public PedidoProduto(Pedido pedido, Produto produto) {
		
		
		this.id.setIdPedido(pedido.getId());
		this.id.setIdProduto(produto.getId());
		
		this.pedido = pedido;
		this.produto = produto;
	}*/
	
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public PedidoProdutoPK getId() {
		return id;
	}

	public void setId(PedidoProdutoPK id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
		this.id.setIdPedido(pedido.getId());
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
		this.id.setIdProduto(produto.getId());
	}
	
	

}
