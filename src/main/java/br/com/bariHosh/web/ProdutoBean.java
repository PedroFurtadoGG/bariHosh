package br.com.bariHosh.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.bariHosh.entidade.CategoriaProduto;
import br.com.bariHosh.entidade.Estoque;
import br.com.bariHosh.entidade.Fornecedor;
import br.com.bariHosh.entidade.Marca;
import br.com.bariHosh.entidade.Produto;
import br.com.bariHosh.negocio.CategoriaProdutoRN;
import br.com.bariHosh.negocio.FornecedorRN;
import br.com.bariHosh.negocio.MarcaRN;
import br.com.bariHosh.negocio.ProdutoRN;

@ManagedBean(name = "produtoBean")
@RequestScoped
public class ProdutoBean {

	private Produto produto = new Produto();
	private Marca marca = new Marca();
	private Fornecedor fornecedor = new Fornecedor();
	private CategoriaProduto categoria = new CategoriaProduto();
	private Estoque estoque = new Estoque();
	private String destinoSalvar;
	private ProdutoRN produtoRN = new ProdutoRN();
	private List<Produto> listaProdutos;
	private List<Marca> listaMarcas;
	private List<Fornecedor> listaFornecedor;
	private List<CategoriaProduto> listaCategorias;	
	private List<Estoque> listaEstoque;
	
	
	private Produto produtoFiltro = new Produto();

	public ProdutoBean() {		
		this.destinoSalvar = "produtos";	
		this.estoque.setProduto(this.produto);
		this.produto.setMarca_produto(this.marca);
		this.produto.setFornecedor(this.fornecedor);
		this.produto.setCategoria(this.categoria);		
		this.produto.setEstoque(this.estoque);
		this.produto.setAtivo(true);
		this.produto.getEstoque().setAtivo(true);
	
		
		
	}

	public String novo() {
	
		this.marca = new Marca();
		this.fornecedor = new Fornecedor();
		this.categoria = new CategoriaProduto();	
		this.estoque = new Estoque();
		this.produto = new Produto();
		this.estoque.setProduto(produto);			
		this.produto.setMarca_produto(marca);
		this.produto.setFornecedor(fornecedor);
		this.produto.setCategoria(categoria);		
		this.produto.setEstoque(estoque);
		return "/restrito/produto/produto";
	}

	public String editar() {	
		return "/restrito/produto/produto";
	}

	public String excluir() {		
		if(produtoRN.excluir(this.produto)) {;
		    this.listaProdutos = null;
	     	return null;
		}
	    return null;

	}
	
	public String filtrar() {
		
		this.listaProdutos = produtoRN.listaFiltrada(produtoFiltro.getNome(), produtoFiltro.getValorEntrada(), produto.getValorSaida(), produtoFiltro.getCodigo_barras());
		
		return "/restrito/produto/produtos";
	}

	public String salvar() {		
		if (this.produtoRN.salvar(this.produto)) {
			return this.destinoSalvar;
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

	public List<Produto> getListaProdutos() {

		if (this.listaProdutos == null) {
			this.listaProdutos = produtoRN.listarCompleto();
		}
//		else {
//			this.listaProdutos = produtoRN.listaFiltrada(produtoFiltro.getNome(), produtoFiltro.getValorEntrada(), produto.getValorSaida(), produtoFiltro.getCodigo_barras());
//		}
		return this.listaProdutos;
	}
	
	public List<Produto> getListaProdutosFiltro() {

		if (this.listaProdutos == null) {
			this.listaProdutos = produtoRN.listaFiltrada(produtoFiltro.getNome(), produtoFiltro.getValorEntrada(), produto.getValorSaida(), produtoFiltro.getCodigo_barras());
		}
		
		return this.listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public List<Marca> getListaMarcas() {
		if (this.listaMarcas == null) {
			MarcaRN marcaRN = new MarcaRN();
			this.listaMarcas = marcaRN.listar();
		}
		return this.listaMarcas;
	}

	public void setListaMarcas(List<Marca> listaMarcas) {
		this.listaMarcas = listaMarcas;
	}

	public List<Fornecedor> getListaFornecedor() {
		if (this.listaFornecedor == null) {
			FornecedorRN fornecedorRN = new FornecedorRN();
			this.listaFornecedor = fornecedorRN.listar();
		}
		return this.listaFornecedor;
	}

	public void setListaFornecedor(List<Fornecedor> listaFornecedor) {
		this.listaFornecedor = listaFornecedor;
	}

	public List<CategoriaProduto> getListaCategorias() {
		if (this.listaCategorias == null) {
			CategoriaProdutoRN categoriaRN = new CategoriaProdutoRN();
			this.listaCategorias = categoriaRN.listar();
		}
		return this.listaCategorias;
	}

	public void setListaCategorias(List<CategoriaProduto> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

	

	public List<Estoque> getListaEstoque() {
		return listaEstoque;
	}

	public void setListaEstoque(List<Estoque> listaEstoque) {
		this.listaEstoque = listaEstoque;
	}

	public Produto getProdutoFiltro() {
		return produtoFiltro;
	}

	public void setProdutoFiltro(Produto produtoFiltro) {
		this.produtoFiltro = produtoFiltro;
	}
	
	

	

}
