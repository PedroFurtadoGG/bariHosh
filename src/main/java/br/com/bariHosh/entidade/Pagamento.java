package br.com.bariHosh.entidade;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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

@Entity
@Table(name = "pagamento")
public class Pagamento implements Serializable {

	
	private static final long serialVersionUID = -7227621808219296302L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private float valorAcrescimo;
	private float desconto;
	private float ValorTotal;
	
	

	@Enumerated(EnumType.STRING)
	private FormaPagamento formaPagamento;
	
	@Enumerated(EnumType.STRING)
	private EnumStatusPagamento  statusPagamento;
	
	@Column(name = "completamente_recebido", nullable = false)
	private boolean completamenteRecebido;	

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_despesa")
	private Despesa despesa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public EnumStatusPagamento getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(EnumStatusPagamento statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public boolean isCompletamenteRecebido() {
		return completamenteRecebido;
	}

	public void setCompletamenteRecebido(boolean completamenteRecebido) {
		this.completamenteRecebido = completamenteRecebido;
	}

	

	public Despesa getDespesa() {
		return despesa;
	}

	public void setDespesa(Despesa despesa) {
		this.despesa = despesa;
	}
	
	public float getValorAcrescimo() {
		return valorAcrescimo;
	}
	public void setValorAcrescimo(float valorAcrescimo) {
		this.valorAcrescimo = valorAcrescimo;
	}
	
	public float getDesconto() {
		return desconto;
	}

	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}

	public float getValorTotal() {
		return ValorTotal;
	}

	public void setValorTotal(float valorTotal) {
		ValorTotal = valorTotal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(ValorTotal);
		result = prime * result + (completamenteRecebido ? 1231 : 1237);
		result = prime * result + Float.floatToIntBits(desconto);
		result = prime * result + ((despesa == null) ? 0 : despesa.hashCode());
		result = prime * result + ((formaPagamento == null) ? 0 : formaPagamento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((statusPagamento == null) ? 0 : statusPagamento.hashCode());
		result = prime * result + Float.floatToIntBits(valorAcrescimo);
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
		Pagamento other = (Pagamento) obj;
		if (Float.floatToIntBits(ValorTotal) != Float.floatToIntBits(other.ValorTotal))
			return false;
		if (completamenteRecebido != other.completamenteRecebido)
			return false;
		if (Float.floatToIntBits(desconto) != Float.floatToIntBits(other.desconto))
			return false;
		if (despesa == null) {
			if (other.despesa != null)
				return false;
		} else if (!despesa.equals(other.despesa))
			return false;
		if (formaPagamento != other.formaPagamento)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (statusPagamento != other.statusPagamento)
			return false;
		if (Float.floatToIntBits(valorAcrescimo) != Float.floatToIntBits(other.valorAcrescimo))
			return false;
		return true;
	}

	
	
	
}
