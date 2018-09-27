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
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_produto;

	private String codigo_barras;
	private String nome;
	private String descricao;
	private Float valorEntrada;
	private Float valorSaida;
	private boolean ativo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario_criador;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_categoria_produto", nullable = false)
	private CategoriaProduto categoria;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_fornecedor", nullable = false)
	private Fornecedor fornecedor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_marca_produto", nullable = false)
	private Marca marca_produto;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false, precision = 10, scale = 2)
	@NotNull
	private Date data_criacao;
	@Temporal(TemporalType.DATE)
	@Column(nullable = false, precision = 10, scale = 2)
	@NotNull
	private Date data_alteracao;

	public Long getId_produto() {
		return id_produto;
	}

	public void setId_produto(Long id_produto) {
		this.id_produto = id_produto;
	}

	public String getCodigo_barras() {
		return codigo_barras;
	}

	public void setCodigo_barras(String codigo_barras) {
		this.codigo_barras = codigo_barras;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Float getValorEntrada() {
		return valorEntrada;
	}

	public void setValorEntrada(Float valorEntrada) {
		this.valorEntrada = valorEntrada;
	}

	public Float getValorSaida() {
		return valorSaida;
	}

	public void setValorSaida(Float valorSaida) {
		this.valorSaida = valorSaida;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Usuario getUsuario_criador() {
		return usuario_criador;
	}

	public void setUsuario_criador(Usuario usuario_criador) {
		this.usuario_criador = usuario_criador;
	}

	public CategoriaProduto getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaProduto categoria) {
		this.categoria = categoria;
	}

	public Marca getMarca_produto() {
		return marca_produto;
	}

	public void setMarca_produto(Marca marca_produto) {
		this.marca_produto = marca_produto;
	}

	public Date getData_criacao() {
		return data_criacao;
	}

	public void setData_criacao(Date data_criacao) {
		this.data_criacao = data_criacao;
	}

	public Date getData_alteracao() {
		return data_alteracao;
	}

	public void setData_alteracao(Date data_alteracao) {
		this.data_alteracao = data_alteracao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((codigo_barras == null) ? 0 : codigo_barras.hashCode());
		result = prime * result + ((data_alteracao == null) ? 0 : data_alteracao.hashCode());
		result = prime * result + ((data_criacao == null) ? 0 : data_criacao.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((fornecedor == null) ? 0 : fornecedor.hashCode());
		result = prime * result + ((id_produto == null) ? 0 : id_produto.hashCode());
		result = prime * result + (ativo ? 1231 : 1237);
		result = prime * result + ((marca_produto == null) ? 0 : marca_produto.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((usuario_criador == null) ? 0 : usuario_criador.hashCode());
		result = prime * result + ((valorEntrada == null) ? 0 : valorEntrada.hashCode());
		result = prime * result + ((valorSaida == null) ? 0 : valorSaida.hashCode());
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
		Produto other = (Produto) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (codigo_barras == null) {
			if (other.codigo_barras != null)
				return false;
		} else if (!codigo_barras.equals(other.codigo_barras))
			return false;
		if (data_alteracao == null) {
			if (other.data_alteracao != null)
				return false;
		} else if (!data_alteracao.equals(other.data_alteracao))
			return false;
		if (data_criacao == null) {
			if (other.data_criacao != null)
				return false;
		} else if (!data_criacao.equals(other.data_criacao))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (fornecedor == null) {
			if (other.fornecedor != null)
				return false;
		} else if (!fornecedor.equals(other.fornecedor))
			return false;
		if (id_produto == null) {
			if (other.id_produto != null)
				return false;
		} else if (!id_produto.equals(other.id_produto))
			return false;
		if (ativo != other.ativo)
			return false;
		if (marca_produto == null) {
			if (other.marca_produto != null)
				return false;
		} else if (!marca_produto.equals(other.marca_produto))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (usuario_criador == null) {
			if (other.usuario_criador != null)
				return false;
		} else if (!usuario_criador.equals(other.usuario_criador))
			return false;
		if (valorEntrada == null) {
			if (other.valorEntrada != null)
				return false;
		} else if (!valorEntrada.equals(other.valorEntrada))
			return false;
		if (valorSaida == null) {
			if (other.valorSaida != null)
				return false;
		} else if (!valorSaida.equals(other.valorSaida))
			return false;
		return true;
	}

}
