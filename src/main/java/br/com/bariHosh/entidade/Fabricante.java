package br.com.bariHosh.entidade;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "fabricante")
public class Fabricante implements Serializable{

	private static final long serialVersionUID = 27082973257799897L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_fabricante;
	
	private String razaoSocial;
	private String nomeFantasia;
	private String cnpj;
	 
	@OneToMany(mappedBy="fabricante", fetch=FetchType.LAZY , targetEntity = Marca.class)
	private Set<Marca> marcas;
	
	public Long getId_fabricante() {
		return id_fabricante;
	}
	public void setId_fabricante(Long id_fabricante) {
		this.id_fabricante = id_fabricante;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public Set<Marca> getMarcas() {
		return marcas;
	}
	public void setMarcas(Set<Marca> marcas) {
		this.marcas = marcas;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((id_fabricante == null) ? 0 : id_fabricante.hashCode());
		result = prime * result + ((marcas == null) ? 0 : marcas.hashCode());
		result = prime * result + ((nomeFantasia == null) ? 0 : nomeFantasia.hashCode());
		result = prime * result + ((razaoSocial == null) ? 0 : razaoSocial.hashCode());
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
		Fabricante other = (Fabricante) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (id_fabricante == null) {
			if (other.id_fabricante != null)
				return false;
		} else if (!id_fabricante.equals(other.id_fabricante))
			return false;
		if (marcas == null) {
			if (other.marcas != null)
				return false;
		} else if (!marcas.equals(other.marcas))
			return false;
		if (nomeFantasia == null) {
			if (other.nomeFantasia != null)
				return false;
		} else if (!nomeFantasia.equals(other.nomeFantasia))
			return false;
		if (razaoSocial == null) {
			if (other.razaoSocial != null)
				return false;
		} else if (!razaoSocial.equals(other.razaoSocial))
			return false;
		return true;
	}
	
	
	
	
	
}
