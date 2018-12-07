package br.com.bariHosh.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "caixa")
public class Caixa implements Serializable {

	private static final long serialVersionUID = -7677089166028474024L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_caixa;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "caixa", fetch = FetchType.LAZY)
	private List<Movimentacao> movimentacaoCaixa = new ArrayList<Movimentacao>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario usuarioCaixa;

	private Float valorAbertura;

	private Float valorFechamento;

	private Float valorTotal;

	@Temporal(TemporalType.DATE)
	private Date data_abertura;

	@Temporal(TemporalType.DATE)
	private Date data_fechamento;

	@Enumerated(EnumType.STRING)
	private EnumStatusCaixa statusCaixa;

	public Long getId_caixa() {
		return id_caixa;
	}

	public void setId_caixa(Long id_caixa) {
		this.id_caixa = id_caixa;
	}

	public List<Movimentacao> getMovimentacaoCaixa() {
		return movimentacaoCaixa;
	}

	public void setMovimentacaoCaixa(List<Movimentacao> movimentacaoCaixa) {
		this.movimentacaoCaixa = movimentacaoCaixa;
	}

	public Usuario getUsuarioCaixa() {
		return usuarioCaixa;
	}

	public void setUsuarioCaixa(Usuario usuarioCaixa) {
		this.usuarioCaixa = usuarioCaixa;
	}

	public Float getValorAbertura() {
		return valorAbertura;
	}

	public void setValorAbertura(Float valorAbertura) {
		this.valorAbertura = valorAbertura;
	}

	public Float getValorFechamento() {
		return valorFechamento;
	}

	public void setValorFechamento(Float valorFechamento) {
		this.valorFechamento = valorFechamento;
	}

	public Float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Date getData_abertura() {
		return data_abertura;
	}

	public void setData_abertura(Date data_abertura) {
		this.data_abertura = data_abertura;
	}

	public Date getData_fechamento() {
		return data_fechamento;
	}

	public void setData_fechamento(Date data_fechamento) {
		this.data_fechamento = data_fechamento;
	}

	public EnumStatusCaixa getStatusCaixa() {
		return statusCaixa;
	}

	public void setStatusCaixa(EnumStatusCaixa statusCaixa) {
		this.statusCaixa = statusCaixa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data_abertura == null) ? 0 : data_abertura.hashCode());
		result = prime * result + ((data_fechamento == null) ? 0 : data_fechamento.hashCode());
		result = prime * result + ((id_caixa == null) ? 0 : id_caixa.hashCode());
		result = prime * result + ((movimentacaoCaixa == null) ? 0 : movimentacaoCaixa.hashCode());
		result = prime * result + ((statusCaixa == null) ? 0 : statusCaixa.hashCode());
		result = prime * result + ((usuarioCaixa == null) ? 0 : usuarioCaixa.hashCode());
		result = prime * result + ((valorAbertura == null) ? 0 : valorAbertura.hashCode());
		result = prime * result + ((valorFechamento == null) ? 0 : valorFechamento.hashCode());
		result = prime * result + ((valorTotal == null) ? 0 : valorTotal.hashCode());
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
		if (data_abertura == null) {
			if (other.data_abertura != null)
				return false;
		} else if (!data_abertura.equals(other.data_abertura))
			return false;
		if (data_fechamento == null) {
			if (other.data_fechamento != null)
				return false;
		} else if (!data_fechamento.equals(other.data_fechamento))
			return false;
		if (id_caixa == null) {
			if (other.id_caixa != null)
				return false;
		} else if (!id_caixa.equals(other.id_caixa))
			return false;
		if (movimentacaoCaixa == null) {
			if (other.movimentacaoCaixa != null)
				return false;
		} else if (!movimentacaoCaixa.equals(other.movimentacaoCaixa))
			return false;
		if (statusCaixa != other.statusCaixa)
			return false;
		if (usuarioCaixa == null) {
			if (other.usuarioCaixa != null)
				return false;
		} else if (!usuarioCaixa.equals(other.usuarioCaixa))
			return false;
		if (valorAbertura == null) {
			if (other.valorAbertura != null)
				return false;
		} else if (!valorAbertura.equals(other.valorAbertura))
			return false;
		if (valorFechamento == null) {
			if (other.valorFechamento != null)
				return false;
		} else if (!valorFechamento.equals(other.valorFechamento))
			return false;
		if (valorTotal == null) {
			if (other.valorTotal != null)
				return false;
		} else if (!valorTotal.equals(other.valorTotal))
			return false;
		return true;
	}

	
}
