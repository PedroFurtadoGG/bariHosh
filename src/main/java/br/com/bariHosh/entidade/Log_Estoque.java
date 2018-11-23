package br.com.bariHosh.entidade;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Log_Estoque  implements Serializable  {

	private static final long serialVersionUID = -7221258183866011712L;
	
	private String descricao;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_log_estoque;
	@Enumerated(EnumType.STRING)
	private EnumTipoRegistro tipo_movimentacao;

	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "id_estoque", nullable = false)
	private Estoque estoque;

	@OneToOne(fetch = FetchType.LAZY )	
	@JoinColumn(name = "id_usuariomovimentador", nullable = false)
	private Usuario usuario_movimentador;

	@Temporal(TemporalType.DATE)	
	private Date dt_movimentacao;

	public Long getId_log_estoque() {
		return id_log_estoque;
	}

	public void setId_log_estoque(Long id) {
		this.id_log_estoque = id;
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

	
	public EnumTipoRegistro getTipo_movimentacao() {
		return tipo_movimentacao;
	}

	public void setTipo_movimentacao(EnumTipoRegistro tipo_movimentacao) {
		this.tipo_movimentacao = tipo_movimentacao;
	}

	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
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
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
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
		if (tipo_movimentacao != other.tipo_movimentacao)
			return false;
		if (usuario_movimentador == null) {
			if (other.usuario_movimentador != null)
				return false;
		} else if (!usuario_movimentador.equals(other.usuario_movimentador))
			return false;
		return true;
	}

	

}
