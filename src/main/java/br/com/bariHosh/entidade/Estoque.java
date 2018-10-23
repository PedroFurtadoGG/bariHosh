package br.com.bariHosh.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "estoque")
public class Estoque implements Serializable  {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_estoque;

	@OneToMany(mappedBy = "estoque_produto", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Produto.class)
	private List<Produto> produtos;	
	
	@Temporal(TemporalType.DATE)
	private Date dt_validade_lote;

	private Integer qtd_produto;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_saldoEstoque", nullable = false)
	private SaldoEstoque saldoEstoque;

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL }, mappedBy = "estoque")
	private List<Log_Estoque> movimentacao;

	public Long getId_estoque() {
		return id_estoque;
	}

	public void setId_estoque(Long id_estoque) {
		this.id_estoque = id_estoque;
	}


	public Integer getQtd_produto() {
		return qtd_produto;
	}

	public void setQtd_produto(Integer qtd_produto) {
		this.qtd_produto = qtd_produto;
	}

	public List<Log_Estoque> getMovimentacao() {
		return movimentacao;
	}

	public void setMovimentacao(List<Log_Estoque> movimentacao) {
		this.movimentacao = movimentacao;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Date getDt_validade() {
		return dt_validade_lote;
	}

	public void setDt_validade(Date dt_validade) {
		this.dt_validade_lote = dt_validade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dt_validade_lote == null) ? 0 : dt_validade_lote.hashCode());
		result = prime * result + ((id_estoque == null) ? 0 : id_estoque.hashCode());
		result = prime * result + ((movimentacao == null) ? 0 : movimentacao.hashCode());
		result = prime * result + ((produtos == null) ? 0 : produtos.hashCode());
		result = prime * result + ((qtd_produto == null) ? 0 : qtd_produto.hashCode());
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
		Estoque other = (Estoque) obj;
		if (dt_validade_lote == null) {
			if (other.dt_validade_lote != null)
				return false;
		} else if (!dt_validade_lote.equals(other.dt_validade_lote))
			return false;
		if (id_estoque == null) {
			if (other.id_estoque != null)
				return false;
		} else if (!id_estoque.equals(other.id_estoque))
			return false;
		if (movimentacao == null) {
			if (other.movimentacao != null)
				return false;
		} else if (!movimentacao.equals(other.movimentacao))
			return false;
		if (produtos == null) {
			if (other.produtos != null)
				return false;
		} else if (!produtos.equals(other.produtos))
			return false;
		if (qtd_produto == null) {
			if (other.qtd_produto != null)
				return false;
		} else if (!qtd_produto.equals(other.qtd_produto))
			return false;
		return true;
	}

	public SaldoEstoque getSaldoEstoque() {
		return saldoEstoque;
	}

	public void setSaldoEstoque(SaldoEstoque saldoEstoque) {
		this.saldoEstoque = saldoEstoque;
	}

}
