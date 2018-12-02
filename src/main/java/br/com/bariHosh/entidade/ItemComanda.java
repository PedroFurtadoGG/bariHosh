package br.com.bariHosh.entidade;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "itemComanda")
public class ItemComanda implements Serializable {

	private static final long serialVersionUID = 3882264367186637840L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_itemComanda;

	private float valorUnitario;
	private float valorTotal;
	private Integer quantidade;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_produto", nullable = false)
	private Produto produto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_comanda")
	private Comanda comanda;

	public ItemComanda() {

	}

	public Long getId_itemComanda() {
		return id_itemComanda;
	}

	public void setId_itemComanda(Long id_itemComanda) {
		this.id_itemComanda = id_itemComanda;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public float getValorUnitario() {
		return valorUnitario;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	public void setValorUnitario(float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comanda == null) ? 0 : comanda.hashCode());
		result = prime * result + ((id_itemComanda == null) ? 0 : id_itemComanda.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
		result = prime * result + Float.floatToIntBits(valorTotal);
		result = prime * result + Float.floatToIntBits(valorUnitario);
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
		ItemComanda other = (ItemComanda) obj;
		if (comanda == null) {
			if (other.comanda != null)
				return false;
		} else if (!comanda.equals(other.comanda))
			return false;
		if (id_itemComanda == null) {
			if (other.id_itemComanda != null)
				return false;
		} else if (!id_itemComanda.equals(other.id_itemComanda))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (quantidade == null) {
			if (other.quantidade != null)
				return false;
		} else if (!quantidade.equals(other.quantidade))
			return false;
		if (Float.floatToIntBits(valorTotal) != Float.floatToIntBits(other.valorTotal))
			return false;
		if (Float.floatToIntBits(valorUnitario) != Float.floatToIntBits(other.valorUnitario))
			return false;
		return true;
	}

	
	

}
