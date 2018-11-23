package br.com.bariHosh.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "caixa")
public class Caixa implements Serializable {

	private static final long serialVersionUID = -7677089166028474024L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_caixa;

	@Enumerated(EnumType.STRING)
	private FormaPagamento forma_pagamento;

	private Double valor_total;

	private Double valor_desconto;

	private Double valor_acrescimo;

	private Integer qtd_prestacao;

	private String categoria;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_produto", nullable = false)
	private Produto produto;

	@Enumerated(EnumType.STRING)
	private EnumMovimentoCaixa tipo_movimento;

	@Temporal(TemporalType.DATE)
	private Date data_movimentacao;

	public Long getId_caixa() {
		return id_caixa;
	}

	public void setId_caixa(Long id_caixa) {
		this.id_caixa = id_caixa;
	}

	public FormaPagamento getForma_pagamento() {
		return forma_pagamento;
	}

	public void setForma_pagamento(FormaPagamento forma_pagamento) {
		this.forma_pagamento = forma_pagamento;
	}

	public Double getValor_total() {
		return valor_total;
	}

	public void setValor_total(Double valor_total) {
		this.valor_total = valor_total;
	}

	public Double getValor_desconto() {
		return valor_desconto;
	}

	public void setValor_desconto(Double valor_desconto) {
		this.valor_desconto = valor_desconto;
	}

	public Double getValor_acrescimo() {
		return valor_acrescimo;
	}

	public void setValor_acrescimo(Double valor_acrescimo) {
		this.valor_acrescimo = valor_acrescimo;
	}

	public Integer getQtd_prestacao() {
		return qtd_prestacao;
	}

	public void setQtd_prestacao(Integer qtd_prestacao) {
		this.qtd_prestacao = qtd_prestacao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public EnumMovimentoCaixa getTipo_movimento() {
		return tipo_movimento;
	}

	public void setTipo_movimento(EnumMovimentoCaixa tipo_movimento) {
		this.tipo_movimento = tipo_movimento;
	}

	public Date getData_movimentacao() {
		return data_movimentacao;
	}

	public void setData_movimentacao(Date data_movimentacao) {
		this.data_movimentacao = data_movimentacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((data_movimentacao == null) ? 0 : data_movimentacao.hashCode());
		result = prime * result + ((forma_pagamento == null) ? 0 : forma_pagamento.hashCode());
		result = prime * result + ((id_caixa == null) ? 0 : id_caixa.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + ((qtd_prestacao == null) ? 0 : qtd_prestacao.hashCode());
		result = prime * result + ((tipo_movimento == null) ? 0 : tipo_movimento.hashCode());
		result = prime * result + ((valor_acrescimo == null) ? 0 : valor_acrescimo.hashCode());
		result = prime * result + ((valor_desconto == null) ? 0 : valor_desconto.hashCode());
		result = prime * result + ((valor_total == null) ? 0 : valor_total.hashCode());
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
		Caixa other = (Caixa) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (data_movimentacao == null) {
			if (other.data_movimentacao != null)
				return false;
		} else if (!data_movimentacao.equals(other.data_movimentacao))
			return false;
		if (forma_pagamento != other.forma_pagamento)
			return false;
		if (id_caixa == null) {
			if (other.id_caixa != null)
				return false;
		} else if (!id_caixa.equals(other.id_caixa))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (qtd_prestacao == null) {
			if (other.qtd_prestacao != null)
				return false;
		} else if (!qtd_prestacao.equals(other.qtd_prestacao))
			return false;
		if (tipo_movimento != other.tipo_movimento)
			return false;
		if (valor_acrescimo == null) {
			if (other.valor_acrescimo != null)
				return false;
		} else if (!valor_acrescimo.equals(other.valor_acrescimo))
			return false;
		if (valor_desconto == null) {
			if (other.valor_desconto != null)
				return false;
		} else if (!valor_desconto.equals(other.valor_desconto))
			return false;
		if (valor_total == null) {
			if (other.valor_total != null)
				return false;
		} else if (!valor_total.equals(other.valor_total))
			return false;
		return true;
	}

}
