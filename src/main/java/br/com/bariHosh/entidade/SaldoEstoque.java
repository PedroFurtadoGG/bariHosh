package br.com.bariHosh.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class SaldoEstoque {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_saldoEstoque;
	private float saldoEstoque;
	
	
	public float getSaldoEstoque() {
		return saldoEstoque;
	}


	public void setSaldoEstoque(float saldoEstoque) {
		this.saldoEstoque = saldoEstoque;
	}


	public Long getId_saldoEstoque() {
		return id_saldoEstoque;
	}


	public void setId_saldoEstoque(Long id_saldoEstoque) {
		this.id_saldoEstoque = id_saldoEstoque;
	}


	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((id_saldoEstoque == null) ? 0 : id_saldoEstoque.hashCode());		
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
		SaldoEstoque other = (SaldoEstoque) obj;		
		if (id_saldoEstoque == null) {
			if (other.id_saldoEstoque != null)
				return false;
		} else if (!id_saldoEstoque.equals(other.id_saldoEstoque))
			return false;		
		if (Float.floatToIntBits(saldoEstoque) != Float.floatToIntBits(other.saldoEstoque))
			return false;
		return true;
	}


	
	
	
}
