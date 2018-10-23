package br.com.bariHosh.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.bariHosh.entidade.Estoque;
import br.com.bariHosh.entidade.Produto;
import br.com.bariHosh.entidade.SaldoEstoque;
import br.com.bariHosh.negocio.EstoqueRN;
import br.com.bariHosh.negocio.ProdutoRN;

@ManagedBean(name = "estoqueBean")
@RequestScoped
public class EstoqueBean {
	
	private Produto produto = new Produto();
	private Estoque estoque = new Estoque();
	private SaldoEstoque saldoEstoque = new SaldoEstoque();
	private List<Produto> listaProdutos = new ArrayList<Produto>();
	private EstoqueRN estoqueRN = new EstoqueRN();
	private ProdutoRN produtoRN = new ProdutoRN();
	private String destinoSalvar;
	private Integer quantiaAdd;
	private Integer quantiaRemove;
	private Integer quantidadeTotalprodutos;
	
	
	
	
	
	public EstoqueBean() {
		this.produto = new Produto();
		this.estoque = new Estoque();
		this.saldoEstoque= new SaldoEstoque();		
		this.estoque.setSaldoEstoque(saldoEstoque);
		this.produto.setEstoque(estoque);
		this.destinoSalvar = "estoque";
		obterTotalProdutosEmEstoqueGeral();
	}
	@PostConstruct
	public void Init() {
		this.produto = new Produto();
		this.estoque = new Estoque();
		this.saldoEstoque= new SaldoEstoque();		
		this.estoque.setSaldoEstoque(saldoEstoque);
		this.produto.setEstoque(estoque);
		this.destinoSalvar = "estoque";
		this.obterTotalProdutosEmEstoqueGeral();		
	}

	// este metodo es responsavel por trazer a quantidade total de itens(produto) dentro do armazenbar
	public String obterTotalProdutosEmEstoqueGeral(){
		 this.quantidadeTotalprodutos =  estoqueRN.obterTotalProdutosEmEstoqueGeral();		
		return this.destinoSalvar;	
	}
	
	public String diminuirProdutoEstoque() {		
		if(estoqueRN.diminuirEstoqueProduto(this.produto.getEstoque(),this.quantiaRemove)){			
			return this.destinoSalvar;	
		}
		return null;
	}
	
	
	public String aumentarProdutoEstoque() {		
		if (estoqueRN.aumentarEstoqueProduto(this.produto.getEstoque(),this.quantiaAdd)) {             
			return this.destinoSalvar;
		}
		return null;
	}
	
	
	public String ativarEstoque() {
		if (this.estoque.isAtivo())
			this.estoque.setAtivo(false);
		else
			this.estoque.setAtivo(true);
	     	estoqueRN.salvar(this.estoque);
		return null;
	}
	

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public SaldoEstoque getSaldoEstoque() {
		return saldoEstoque;
	}

	public void setSaldoEstoque(SaldoEstoque saldoEstoque) {
		this.saldoEstoque = saldoEstoque;
	}

	public EstoqueRN getEstoqueRN() {
		return estoqueRN;
	}

	public void setEstoqueRN(EstoqueRN estoqueRN) {
		this.estoqueRN = estoqueRN;
	}

	public ProdutoRN getProdutoRN() {
		return produtoRN;
	}

	public void setProdutoRN(ProdutoRN produtoRN) {
		this.produtoRN = produtoRN;
	}

	public List<Produto> getListaProdutos() {
		if (this.listaProdutos == null) {
			this.listaProdutos = produtoRN.listar();		}
		return this.listaProdutos;

	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

	public Integer getQuantiaAdd() {
		return quantiaAdd;
	}

	public void setQuantiaAdd(Integer quantiaAdd) {
		this.quantiaAdd = quantiaAdd;
	}

	public Integer getQuantiaRemove() {
		return quantiaRemove;
	}

	public void setQuantiaRemove(Integer quantiaRemove) {
		this.quantiaRemove = quantiaRemove;
	}



	public Integer getQuantidadeTotalprodutos() {
		return quantidadeTotalprodutos;
	}



	public void setQuantidadeTotalprodutos(Integer quantidadeTotal) {
		this.quantidadeTotalprodutos = quantidadeTotal;
	}

}
