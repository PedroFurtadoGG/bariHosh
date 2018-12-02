package br.com.bariHosh.entidade;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "movimentacao")
public class Movimentacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_movimentacao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pagamento")
	private Pagamento pagamentoComanda;
	
	@Temporal(TemporalType.DATE)
	private Date dataInicialMovimentacao;
	
	@Temporal(TemporalType.DATE)
	private Date dataFinalMovimentacao;
	
	@Enumerated(EnumType.STRING)
	private EnumMovimentoCaixa tipo_movimento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_caixa")
	private Caixa caixa;

	public Long getId_movimentacao() {
		return id_movimentacao;
	}

	public void setId_movimentacao(Long id_movimentacao) {
		this.id_movimentacao = id_movimentacao;
	}

	public Pagamento getPagamentoComanda() {
		return pagamentoComanda;
	}

	public void setPagamentoComanda(Pagamento pagamentoComanda) {
		this.pagamentoComanda = pagamentoComanda;
	}

	public Date getDataInicialMovimentacao() {
		return dataInicialMovimentacao;
	}

	public void setDataInicialMovimentacao(Date dataInicialMovimentacao) {
		this.dataInicialMovimentacao = dataInicialMovimentacao;
	}

	public Date getDataFinalMovimentacao() {
		return dataFinalMovimentacao;
	}

	public void setDataFinalMovimentacao(Date dataFinalMovimentacao) {
		this.dataFinalMovimentacao = dataFinalMovimentacao;
	}

	public EnumMovimentoCaixa getTipo_movimento() {
		return tipo_movimento;
	}

	public void setTipo_movimento(EnumMovimentoCaixa tipo_movimento) {
		this.tipo_movimento = tipo_movimento;
	}

	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((caixa == null) ? 0 : caixa.hashCode());
		result = prime * result + ((dataFinalMovimentacao == null) ? 0 : dataFinalMovimentacao.hashCode());
		result = prime * result + ((dataInicialMovimentacao == null) ? 0 : dataInicialMovimentacao.hashCode());
		result = prime * result + ((id_movimentacao == null) ? 0 : id_movimentacao.hashCode());
		result = prime * result + ((pagamentoComanda == null) ? 0 : pagamentoComanda.hashCode());
		result = prime * result + ((tipo_movimento == null) ? 0 : tipo_movimento.hashCode());
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
		Movimentacao other = (Movimentacao) obj;
		if (caixa == null) {
			if (other.caixa != null)
				return false;
		} else if (!caixa.equals(other.caixa))
			return false;
		if (dataFinalMovimentacao == null) {
			if (other.dataFinalMovimentacao != null)
				return false;
		} else if (!dataFinalMovimentacao.equals(other.dataFinalMovimentacao))
			return false;
		if (dataInicialMovimentacao == null) {
			if (other.dataInicialMovimentacao != null)
				return false;
		} else if (!dataInicialMovimentacao.equals(other.dataInicialMovimentacao))
			return false;
		if (id_movimentacao == null) {
			if (other.id_movimentacao != null)
				return false;
		} else if (!id_movimentacao.equals(other.id_movimentacao))
			return false;
		if (pagamentoComanda == null) {
			if (other.pagamentoComanda != null)
				return false;
		} else if (!pagamentoComanda.equals(other.pagamentoComanda))
			return false;
		if (tipo_movimento != other.tipo_movimento)
			return false;
		return true;
	}

	
	

}
