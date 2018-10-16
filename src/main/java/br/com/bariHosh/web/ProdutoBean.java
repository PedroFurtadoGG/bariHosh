package br.com.bariHosh.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.bariHosh.entidade.CategoriaProduto;
import br.com.bariHosh.entidade.Estoque;
import br.com.bariHosh.entidade.Fornecedor;
import br.com.bariHosh.entidade.Marca;
import br.com.bariHosh.entidade.Produto;
import br.com.bariHosh.entidade.Usuario;
import br.com.bariHosh.negocio.ProdutoRN;

@ManagedBean(name="produtoBean")
@RequestScoped
public class ProdutoBean {
	
	private Produto produto = new Produto();
	private  Marca marca = new Marca();
	private Fornecedor fornecedor = new Fornecedor();
	private CategoriaProduto categoria = new CategoriaProduto();
	private Usuario usuario = new Usuario();
	private Estoque estoque = new Estoque();
	private String destinoSalvar ;
	
	private ProdutoRN produtoRN;
	
	private List<Produto> listaProdutos;
	private List<Marca> listaMarcas;
	private List<Fornecedor> listaFornecedor;
	private List<CategoriaProduto> listaCategorias;
	private List<Usuario> listaUsuario;
	private List<Estoque> listaEstoque;
	
	public ProdutoBean() {
		
		this.marca = new Marca();
		this.fornecedor = new Fornecedor();
		this.categoria = new CategoriaProduto();
		this.usuario = new Usuario();
		this.estoque = new Estoque();
		
		this.produto.setMarca_produto(marca);
		this.produto.setFornecedor(fornecedor);
		this.produto.setCategoria(categoria);
		this.produto.setUsuario_criador(usuario);
		this.produto.setEstoque(estoque);
	}
	
	public String novo() {
		this.destinoSalvar = "produtos";
		this.marca = new Marca();
		this.fornecedor = new Fornecedor();
		this.categoria = new CategoriaProduto();
		this.usuario = new Usuario();
		this.estoque = new Estoque();
		
		this.produto = new Produto();
		
		this.produto.setMarca_produto(marca);
		this.produto.setFornecedor(fornecedor);
		this.produto.setCategoria(categoria);
		this.produto.setUsuario_criador(usuario);
		this.produto.setEstoque(estoque);
		
		return "/restrito/produto/produto";

	}
	
	@PostConstruct
	public void init() {
		this.destinoSalvar = "produtos";
		this.marca = new Marca();
		this.fornecedor = new Fornecedor();
		this.categoria = new CategoriaProduto();
		this.usuario = new Usuario();
		this.estoque = new Estoque();
		
		this.produto = new Produto();
		
		this.produto.setMarca_produto(marca);
		this.produto.setFornecedor(fornecedor);
		this.produto.setCategoria(categoria);
		this.produto.setUsuario_criador(usuario);
		this.produto.setEstoque(estoque);
		
	}
	
	public String editar() {
		this.produto.getMarca_produto();
		this.produto.getFornecedor();
		this.produto.getCategoria();
		this.produto.getUsuario_criador();
		this.produto.getEstoque();
		
		
		return "/restrito/produto/produto";
	}
	
	public String excluir(Produto produto) {
		
		produtoRN.excluir(produto);
		return null;
		
	}
	
	public String salvar() {
		if(this.produtoRN.salvar(produto)) {
			return this.destinoSalvar ;
		}
		return null;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public CategoriaProduto getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaProduto categoria) {
		this.categoria = categoria;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

	public List<Produto> getLista() {
		
		if(this.listaProdutos ==null) {
			this.listaProdutos=produtoRN.listar();
		}
		return this.listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public List<Marca> getListaMarcas() {
		return listaMarcas;
	}

	public void setListaMarcas(List<Marca> listaMarcas) {
		this.listaMarcas = listaMarcas;
	}

	public List<Fornecedor> getListaFornecedor() {
		return listaFornecedor;
	}

	public void setListaFornecedor(List<Fornecedor> listaFornecedor) {
		this.listaFornecedor = listaFornecedor;
	}

	public List<CategoriaProduto> getListaCategorias() {
		return listaCategorias;
	}

	public void setListaCategorias(List<CategoriaProduto> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public List<Estoque> getListaEstoque() {
		return listaEstoque;
	}

	public void setListaEstoque(List<Estoque> listaEstoque) {
		this.listaEstoque = listaEstoque;
	}
	
	
	
	
	
	

}
