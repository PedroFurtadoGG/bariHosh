package br.com.bariHosh.entidade;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "fornecedor")
public class Fornecedor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_fornecedor;

	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "id_pessoa", nullable = false)
	@NotNull
	private Pessoa pessoa;
    private boolean ativo;
	private String ramoAtividade;
	private String cnpj;
	private String razao;
	private String numInscricao;

	public Long getId_fornecedor() {
		return id_fornecedor;
	}

	public void setId_fornecedor(Long id_fornecedor) {
		this.id_fornecedor = id_fornecedor;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

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

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((id_fornecedor == null) ? 0 : id_fornecedor.hashCode());
		result = prime * result + ((numInscricao == null) ? 0 : numInscricao.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
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
		if (id_fornecedor == null) {
			if (other.id_fornecedor != null)
				return false;
		} else if (!id_fornecedor.equals(other.id_fornecedor))
			return false;
		if (numInscricao == null) {
			if (other.numInscricao != null)
				return false;
		} else if (!numInscricao.equals(other.numInscricao))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
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
