package br.com.bariHosh.entidade;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class GrupoProduto implements Serializable {

	private static final long serialVersionUID = -8125070377148704699L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idGrupoProduto;
	
	@Enumerated(EnumType.STRING)
	private EnumTipoProduto tipoproduto;
	
	@OneToMany(mappedBy="grupoProduto", cascade = CascadeType.ALL ,fetch=FetchType.LAZY,targetEntity = Produto.class)  
	private Set<Produto> produtos;
	
	
	

	public Long getIdGrupoProduto() {
		return idGrupoProduto;
	}

	public void setIdGrupoProduto(Long idGrupoProduto) {
		this.idGrupoProduto = idGrupoProduto;
	}

	public EnumTipoProduto getTipoproduto() {
		return tipoproduto;
	}

	public void setTipoproduto(EnumTipoProduto tipoproduto) {
		this.tipoproduto = tipoproduto;
	}

	public Set<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idGrupoProduto == null) ? 0 : idGrupoProduto.hashCode());
		result = prime * result + ((produtos == null) ? 0 : produtos.hashCode());		
		result = prime * result + ((tipoproduto == null) ? 0 : tipoproduto.hashCode());
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
		GrupoProduto other = (GrupoProduto) obj;
		if (idGrupoProduto == null) {
			if (other.idGrupoProduto != null)
				return false;
		} else if (!idGrupoProduto.equals(other.idGrupoProduto))
			return false;
		if (produtos == null) {
			if (other.produtos != null)
				return false;
		} else if (!produtos.equals(other.produtos))
			return false;
		
		if (tipoproduto != other.tipoproduto)
			return false;
		return true;
	}

	
}
