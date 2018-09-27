package br.com.bariHosh.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoProduto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_tipoProduto;
	private String descricao;

	public Long getId() {
		return id_tipoProduto;
	}

	public void setId(Long id) {
		this.id_tipoProduto = id;
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
		result = prime * result + ((id_tipoProduto == null) ? 0 : id_tipoProduto.hashCode());
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
		TipoProduto other = (TipoProduto) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id_tipoProduto == null) {
			if (other.id_tipoProduto != null)
				return false;
		} else if (!id_tipoProduto.equals(other.id_tipoProduto))
			return false;
		return true;
	}

}
