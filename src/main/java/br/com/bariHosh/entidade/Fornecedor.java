package br.com.bariHosh.entidade;

import javax.persistence.Entity;

@Entity
public class Fornecedor extends  Pessoa {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3109287710600314331L;
	private String ramoAtividade ;
	private String cnpj;
	private String razao;
	private String numInscricao;
	public String getRamoAtividade() {
		return ramoAtividade;
	}
	public void setRamoAtividade(String ramoAtividade) {
		this.ramoAtividade = ramoAtividade;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazao() {
		return razao;
	}
	public void setRazao(String razao) {
		this.razao = razao;
	}
	public String getNumInscricao() {
		return numInscricao;
	}
	public void setNumInscricao(String numInscricao) {
		this.numInscricao = numInscricao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((numInscricao == null) ? 0 : numInscricao.hashCode());
		result = prime * result + ((ramoAtividade == null) ? 0 : ramoAtividade.hashCode());
		result = prime * result + ((razao == null) ? 0 : razao.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (numInscricao == null) {
			if (other.numInscricao != null)
				return false;
		} else if (!numInscricao.equals(other.numInscricao))
			return false;
		if (ramoAtividade == null) {
			if (other.ramoAtividade != null)
				return false;
		} else if (!ramoAtividade.equals(other.ramoAtividade))
			return false;
		if (razao == null) {
			if (other.razao != null)
				return false;
		} else if (!razao.equals(other.razao))
			return false;
		return true;
	}
	
	
	

}
