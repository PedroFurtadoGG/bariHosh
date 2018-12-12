package br.com.bariHosh.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "sangria")
public class SangriaCaixa  implements Serializable{
	
	
	private static final long serialVersionUID = 8579063408342806864L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_sangria;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false, precision = 10, scale = 2)
	@NotNull
	private  Date data_sangria;
	
	private Float valorSangria;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_caixa")
	private Caixa  caixa;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuariocaixa")
	private Usuario usuario_caixa;
	
	public Long getId_sangria() {
		return id_sangria;
	}
	public void setId_sangria(Long id_sangria) {
		this.id_sangria = id_sangria;
	}
	public Date getData_sangria() {
		return data_sangria;
	}
	public void setData_sangria(Date data_sangria) {
		this.data_sangria = data_sangria;
	}
	public Float getValorSangria() {
		return valorSangria;
	}
	public void setValorSangria(Float valorSangria) {
		this.valorSangria = valorSangria;
	}
	public Usuario getUsuario_caixa() {
		return usuario_caixa;
	}
	public void setUsuario_caixa(Usuario usuario_caixa) {
		this.usuario_caixa = usuario_caixa;
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
		result = prime * result + ((data_sangria == null) ? 0 : data_sangria.hashCode());
		result = prime * result + ((id_sangria == null) ? 0 : id_sangria.hashCode());
		result = prime * result + ((usuario_caixa == null) ? 0 : usuario_caixa.hashCode());
		result = prime * result + ((valorSangria == null) ? 0 : valorSangria.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof SangriaCaixa)) {
			return false;
		}
		SangriaCaixa other = (SangriaCaixa) obj;
		if (caixa == null) {
			if (other.caixa != null) {
				return false;
			}
		} else if (!caixa.equals(other.caixa)) {
			return false;
		}
		if (data_sangria == null) {
			if (other.data_sangria != null) {
				return false;
			}
		} else if (!data_sangria.equals(other.data_sangria)) {
			return false;
		}
		if (id_sangria == null) {
			if (other.id_sangria != null) {
				return false;
			}
		} else if (!id_sangria.equals(other.id_sangria)) {
			return false;
		}
		if (usuario_caixa == null) {
			if (other.usuario_caixa != null) {
				return false;
			}
		} else if (!usuario_caixa.equals(other.usuario_caixa)) {
			return false;
		}
		if (valorSangria == null) {
			if (other.valorSangria != null) {
				return false;
			}
		} else if (!valorSangria.equals(other.valorSangria)) {
			return false;
		}
		return true;
	}
	
	
	
	

}
