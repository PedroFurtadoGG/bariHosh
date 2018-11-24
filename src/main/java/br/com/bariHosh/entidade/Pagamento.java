package br.com.bariHosh.entidade;

import java.io.Serializable;

import javax.persistence.Column;
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

@Entity
@Table(name = "pagamento")
public class Pagamento implements Serializable {

	private static final long serialVersionUID = -7227621808219296302L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private FormaPagamento formaPagamento;
	
	@Enumerated(EnumType.STRING)
	private EnumStatusPagamento  statusPagamento;
	@Column(name = "completamente_recebido", nullable = false)
	private boolean completamenteRecebido;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")	
	private Usuario usuario;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_comanda")	
	private Comanda comanda;

	public Pagamento() {

	}

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

	public boolean isCompletamenteRecebido() {
		return completamenteRecebido;
	}

	public void setCompletamenteRecebido(boolean completamenteRecebido) {
		this.completamenteRecebido = completamenteRecebido;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	

	public EnumStatusPagamento getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(EnumStatusPagamento statusPagamento) {
		this.statusPagamento = statusPagamento;
	}
	
	

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comanda == null) ? 0 : comanda.hashCode());
		result = prime * result + (completamenteRecebido ? 1231 : 1237);
		result = prime * result + ((formaPagamento == null) ? 0 : formaPagamento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((statusPagamento == null) ? 0 : statusPagamento.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		if (!(obj instanceof Pagamento)) {
			return false;
		}
		Pagamento other = (Pagamento) obj;
		if (comanda == null) {
			if (other.comanda != null) {
				return false;
			}
		} else if (!comanda.equals(other.comanda)) {
			return false;
		}
		if (completamenteRecebido != other.completamenteRecebido) {
			return false;
		}
		if (formaPagamento != other.formaPagamento) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (statusPagamento != other.statusPagamento) {
			return false;
		}
		if (usuario == null) {
			if (other.usuario != null) {
				return false;
			}
		} else if (!usuario.equals(other.usuario)) {
			return false;
		}
		return true;
	}

	
}
