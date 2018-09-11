package br.com.bariHosh.entidade;

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
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String codigo_barras;
	private Fornecedor fornecedor;
	private String nome;
	private String descricao;
	private Float valorEntrada;
	private Float valorSaida;
	private boolean isAtivo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_produto_id", nullable = false)
	private Usuario usuario_criador;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo_produto", nullable = false)
	private TipoProduto tipoProduto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoria_produto", nullable = false)
	private CategoriaProduto categoria;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "marca_produto", nullable = false)
	private Marca marca_produto;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, precision = 10, scale = 2)
	@NotNull
	private Date data_criacao;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, precision = 10, scale = 2)
	@NotNull
	private Date data_alteracao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Usuario getUsuario_criador() {
		return usuario_criador;
	}

	public void setUsuario_criador(Usuario usuario_criador) {
		this.usuario_criador = usuario_criador;
	}

	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
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
		return isAtivo;
	}

	public void setAtivo(boolean isAtivo) {
		this.isAtivo = isAtivo;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isAtivo ? 1231 : 1237);
		result = prime * result + ((marca_produto == null) ? 0 : marca_produto.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tipoProduto == null) ? 0 : tipoProduto.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isAtivo != other.isAtivo)
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
		if (tipoProduto == null) {
			if (other.tipoProduto != null)
				return false;
		} else if (!tipoProduto.equals(other.tipoProduto))
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
