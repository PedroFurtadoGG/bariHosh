package br.com.bariHosh.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa implements Serializable{
	
	
	  private static final long serialVersionUID = 1L;
	  @Id	
	  @GeneratedValue (strategy = GenerationType.TABLE)
	  @SequenceGenerator(name = "pessoa_seq", sequenceName = "pessoa_seq", allocationSize = 1, initialValue = 1)
	  private Long id;
	  private String nome;
	  private String rg;
	  private String cpf;   
	  private String sexo;
	  private String telefone;
	  private String email;	
	  private String idioma;	 
	  private Long id_usuario_criacao;
	  private boolean ativo;	 
	  @OneToOne
	  private Endereco endereco;    
      
	  @Temporal(TemporalType.TIMESTAMP)
	  private Date dt_nascimento;
	  @Temporal(TemporalType.TIMESTAMP)
	  private Date dt_criacao;
	  @Temporal(TemporalType.TIMESTAMP)
	  private Date dt_alteracao;
	  
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDt_nascimento() {
		return dt_nascimento;
	}
	public void setDt_nascimento(Date dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}
	public Date getDt_criacao() {
		return dt_criacao;
	}
	public void setDt_criacao(Date dt_criacao) {
		this.dt_criacao = dt_criacao;
	}
	public Date getDt_alteracao() {
		return dt_alteracao;
	}
	public void setDt_alteracao(Date dt_alteracao) {
		this.dt_alteracao = dt_alteracao;
	}
	 public String getIdioma() {
			return idioma;
		}
		public void setIdioma(String idioma) {
			this.idioma = idioma;
		}
	  public Long getId_usuario_criacao() {
			return id_usuario_criacao;
		}
		public void setId_usuario_criacao(Long id_usuario_criacao) {
			this.id_usuario_criacao = id_usuario_criacao;
		}
		
		public boolean isAtivo() {
			return ativo;
		}
		public void setAtivo(boolean ativo) {
			this.ativo = ativo;
		}
		public Endereco getEndereco() {
			return endereco;
		}
		public void setEndereco(Endereco endereco) {
			this.endereco = endereco;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
			result = prime * result + ((dt_alteracao == null) ? 0 : dt_alteracao.hashCode());
			result = prime * result + ((dt_criacao == null) ? 0 : dt_criacao.hashCode());
			result = prime * result + ((dt_nascimento == null) ? 0 : dt_nascimento.hashCode());
			result = prime * result + ((email == null) ? 0 : email.hashCode());
			result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((id_usuario_criacao == null) ? 0 : id_usuario_criacao.hashCode());
			result = prime * result + ((idioma == null) ? 0 : idioma.hashCode());
			result = prime * result + ((nome == null) ? 0 : nome.hashCode());
			result = prime * result + ((rg == null) ? 0 : rg.hashCode());
			result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
			result = prime * result + (ativo ? 1231 : 1237);
			result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
			Pessoa other = (Pessoa) obj;
			if (cpf == null) {
				if (other.cpf != null)
					return false;
			} else if (!cpf.equals(other.cpf))
				return false;
			if (dt_alteracao == null) {
				if (other.dt_alteracao != null)
					return false;
			} else if (!dt_alteracao.equals(other.dt_alteracao))
				return false;
			if (dt_criacao == null) {
				if (other.dt_criacao != null)
					return false;
			} else if (!dt_criacao.equals(other.dt_criacao))
				return false;
			if (dt_nascimento == null) {
				if (other.dt_nascimento != null)
					return false;
			} else if (!dt_nascimento.equals(other.dt_nascimento))
				return false;
			if (email == null) {
				if (other.email != null)
					return false;
			} else if (!email.equals(other.email))
				return false;
			if (endereco == null) {
				if (other.endereco != null)
					return false;
			} else if (!endereco.equals(other.endereco))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (id_usuario_criacao == null) {
				if (other.id_usuario_criacao != null)
					return false;
			} else if (!id_usuario_criacao.equals(other.id_usuario_criacao))
				return false;
			if (idioma == null) {
				if (other.idioma != null)
					return false;
			} else if (!idioma.equals(other.idioma))
				return false;
			if (nome == null) {
				if (other.nome != null)
					return false;
			} else if (!nome.equals(other.nome))
				return false;
			if (rg == null) {
				if (other.rg != null)
					return false;
			} else if (!rg.equals(other.rg))
				return false;
			if (sexo == null) {
				if (other.sexo != null)
					return false;
			} else if (!sexo.equals(other.sexo))
				return false;
			if (ativo != other.ativo)
				return false;
			if (telefone == null) {
				if (other.telefone != null)
					return false;
			} else if (!telefone.equals(other.telefone))
				return false;
			return true;
		}
	
	 


}
