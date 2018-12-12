package br.com.bariHosh.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "estoque")
public class Estoque implements Serializable  {

	private static final long serialVersionUID = 8264949375762622529L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_estoque;
	private Integer qtd_produto;
    private float saldoEstoque;
	private boolean ativo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estoque_produto",referencedColumnName="id_produto")
	private Produto produto;

	

	@OneToMany(mappedBy = "estoque", fetch = FetchType.LAZY)
	private List<Log_Estoque> movimentacao = new ArrayList<Log_Estoque>() ;

	@Temporal(TemporalType.DATE)	
	private Date data_criacao;

	@Temporal(TemporalType.DATE)	
	private Date data_validade_lote;

	@Temporal(TemporalType.DATE)	
	private Date data_finalizacao;

	public Long getId_estoque() {
		return id_estoque;
	}

	public void setId_estoque(Long id_estoque) {
		this.id_estoque = id_estoque;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produtos) {
		this.produto = produtos;
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

	public float getSaldoEstoque() {
		return saldoEstoque;
	}


	public void setSaldoEstoque(float saldoEstoque) {
		this.saldoEstoque = saldoEstoque;
	}

	public Date getData_validade_lote() {
		return data_validade_lote;
	}

	public void setData_validade_lote(Date data_validade_lote) {
		this.data_validade_lote = data_validade_lote;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Date getData_criacao() {
		return data_criacao;
	}

	public void setData_criacao(Date data_criacao) {
		this.data_criacao = data_criacao;
	}

	public Date getData_finalizacao() {
		return data_finalizacao;
	}

	public void setData_finalizacao(Date data_finalizacao) {
		this.data_finalizacao = data_finalizacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ativo ? 1231 : 1237);
		result = prime * result + ((data_criacao == null) ? 0 : data_criacao.hashCode());
		result = prime * result + ((data_finalizacao == null) ? 0 : data_finalizacao.hashCode());
		result = prime * result + ((data_validade_lote == null) ? 0 : data_validade_lote.hashCode());
		result = prime * result + ((id_estoque == null) ? 0 : id_estoque.hashCode());
		result = prime * result + ((movimentacao == null) ? 0 : movimentacao.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + ((qtd_produto == null) ? 0 : qtd_produto.hashCode());
		result = prime * result + Float.floatToIntBits(saldoEstoque);
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
		if (ativo != other.ativo)
			return false;
		if (data_criacao == null) {
			if (other.data_criacao != null)
				return false;
		} else if (!data_criacao.equals(other.data_criacao))
			return false;
		if (data_finalizacao == null) {
			if (other.data_finalizacao != null)
				return false;
		} else if (!data_finalizacao.equals(other.data_finalizacao))
			return false;
		if (data_validade_lote == null) {
			if (other.data_validade_lote != null)
				return false;
		} else if (!data_validade_lote.equals(other.data_validade_lote))
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
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (qtd_produto == null) {
			if (other.qtd_produto != null)
				return false;
		} else if (!qtd_produto.equals(other.qtd_produto))
			return false;
		if (Float.floatToIntBits(saldoEstoque) != Float.floatToIntBits(other.saldoEstoque))
			return false;
		return true;
	}

	
}
