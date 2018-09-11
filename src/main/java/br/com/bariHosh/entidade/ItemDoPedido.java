package br.com.bariHosh.entidade;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "item_do_pedido")
public class ItemDoPedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	private BigDecimal valorUnitario;	
	private BigDecimal valorTotal;
	private Long quantidade;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="item_produto", nullable=false)
	private Produto produto;	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="item_pedido", nullable=false)
	private Pedido pedido;
	

	
	public ItemDoPedido() {
		setQuantidade(1L);
		setValorUnitario(BigDecimal.ZERO);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Min(1)
	@NotNull
	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	
	
	
	@Column(name="valor_unitario", precision=10, scale=2)
	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	@Transient
	public BigDecimal getValorTotal() {
		if (valorUnitario != null && quantidade != null) {
			this.valorTotal = valorUnitario.multiply(new BigDecimal(quantidade));
		}
		
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	

}
