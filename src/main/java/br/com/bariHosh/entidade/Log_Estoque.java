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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Log_Estoque  implements Serializable  {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_log_estoque;

	private String tipo_movimentacao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estoque", nullable = false)
	private Estoque estoque;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuariomovimentador", nullable = false)
	private Usuario usuario_movimentador;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false, precision = 10, scale = 2)
	@NotNull
	private Date dt_movimentacao;

	public Long getId_log_estoque() {
		return id_log_estoque;
	}

	public void setId_log_estoque(Long id) {
		this.id_log_estoque = id;
	}

	public String getTipo_movimentacao() {
		return tipo_movimentacao;
	}

	public void setTipo_movimentacao(String tipo_movimentacao) {
		this.tipo_movimentacao = tipo_movimentacao;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public Usuario getUsuario_movimentador() {
		return usuario_movimentador;
	}

	public void setUsuario_movimentador(Usuario usuario_movimentador) {
		this.usuario_movimentador = usuario_movimentador;
	}

	public Date getDt_movimentacao() {
		return dt_movimentacao;
	}

	public void setDt_movimentacao(Date dt_movimentacao) {
		this.dt_movimentacao = dt_movimentacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dt_movimentacao == null) ? 0 : dt_movimentacao.hashCode());
		result = prime * result + ((estoque == null) ? 0 : estoque.hashCode());
		result = prime * result + ((id_log_estoque == null) ? 0 : id_log_estoque.hashCode());
		result = prime * result + ((tipo_movimentacao == null) ? 0 : tipo_movimentacao.hashCode());
		result = prime * result + ((usuario_movimentador == null) ? 0 : usuario_movimentador.hashCode());
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
		Log_Estoque other = (Log_Estoque) obj;
		if (dt_movimentacao == null) {
			if (other.dt_movimentacao != null)
				return false;
		} else if (!dt_movimentacao.equals(other.dt_movimentacao))
			return false;
		if (estoque == null) {
			if (other.estoque != null)
				return false;
		} else if (!estoque.equals(other.estoque))
			return false;
		if (id_log_estoque == null) {
			if (other.id_log_estoque != null)
				return false;
		} else if (!id_log_estoque.equals(other.id_log_estoque))
			return false;
		if (tipo_movimentacao == null) {
			if (other.tipo_movimentacao != null)
				return false;
		} else if (!tipo_movimentacao.equals(other.tipo_movimentacao))
			return false;
		if (usuario_movimentador == null) {
			if (other.usuario_movimentador != null)
				return false;
		} else if (!usuario_movimentador.equals(other.usuario_movimentador))
			return false;
		return true;
	}

}
