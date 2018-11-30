package br.com.bariHosh.entidade;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Despesa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_despesa;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_comanda")	
	private Comanda comanda;
	
	@Temporal(TemporalType.DATE)
	private Date dataCricacaoDespesa;
	
	private float valorTotalDespesa;
	private float valorAcrescimo;
	
	
	public Long getId_despesa() {
		return id_despesa;
	}
	public void setId_despesa(Long id_despesa) {
		this.id_despesa = id_despesa;
	}
	public Comanda getComanda() {
		return comanda;
	}
	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}
	public Date getDataCricacaoDespesa() {
		return dataCricacaoDespesa;
	}
	public void setDataCricacaoDespesa(Date dataCricacaoDespesa) {
		this.dataCricacaoDespesa = dataCricacaoDespesa;
	}
	public float getValorTotalDespesa() {
		return valorTotalDespesa;
	}
	public void setValorTotalDespesa(float valorTotalDespesa) {
		this.valorTotalDespesa = valorTotalDespesa;
	}
	
	public float getValorAcrescimo() {
		return valorAcrescimo;
	}
	public void setValorAcrescimo(float valorAcrescimo) {
		this.valorAcrescimo = valorAcrescimo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comanda == null) ? 0 : comanda.hashCode());
		result = prime * result + ((dataCricacaoDespesa == null) ? 0 : dataCricacaoDespesa.hashCode());
		result = prime * result + ((id_despesa == null) ? 0 : id_despesa.hashCode());
		result = prime * result + Float.floatToIntBits(valorTotalDespesa);
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
		Despesa other = (Despesa) obj;
		if (comanda == null) {
			if (other.comanda != null)
				return false;
		} else if (!comanda.equals(other.comanda))
			return false;
		if (dataCricacaoDespesa == null) {
			if (other.dataCricacaoDespesa != null)
				return false;
		} else if (!dataCricacaoDespesa.equals(other.dataCricacaoDespesa))
			return false;
		if (id_despesa == null) {
			if (other.id_despesa != null)
				return false;
		} else if (!id_despesa.equals(other.id_despesa))
			return false;
		if (Float.floatToIntBits(valorTotalDespesa) != Float.floatToIntBits(other.valorTotalDespesa))
			return false;
		if (Float.floatToIntBits(valorAcrescimo) != Float.floatToIntBits(other.valorAcrescimo))
			return false;
		return true;
	}
	
	

}
