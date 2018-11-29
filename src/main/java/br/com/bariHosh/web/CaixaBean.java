package br.com.bariHosh.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.bariHosh.entidade.Caixa;
import br.com.bariHosh.entidade.Comanda;
import br.com.bariHosh.entidade.EnumMovimentoCaixa;
import br.com.bariHosh.entidade.FormaPagamento;
import br.com.bariHosh.entidade.ItemComanda;
import br.com.bariHosh.entidade.Produto;
import br.com.bariHosh.negocio.ComandaRN;
import br.com.bariHosh.negocio.ItemComandaRN;
import br.com.bariHosh.negocio.ProdutoRN;

@ManagedBean(name = "caixaBean")
@ViewScoped
public class CaixaBean implements Serializable {

	private static final long serialVersionUID = -6414690959254535730L;

	private FormaPagamento forma_pagamento;
	private EnumMovimentoCaixa tipo_movimentacao;

	private List<ItemComanda> itensComanda;
	private List<Produto> Produtos;

	private String destinoSalvar;
	private ItemComanda itemComanda = new ItemComanda();
	private ItemComandaRN itemComandaRN = new ItemComandaRN();
	private ComandaRN comandaRN = new  ComandaRN();
	private Produto produto = new Produto();
	private Comanda comanda = new Comanda();
	private Long id_comanda;
	private Caixa caixa = new Caixa();

	@PostConstruct
	public void init() {		
		Comanda comanda_encerrada = this.comandaRN.recuperaComandaParaEdicao("id_comanda_encerrada");
		if (comanda_encerrada != null) {
			this.comanda = comanda_encerrada;
		}
	}
	
	
	public String realizarPagamendo(Comanda comanda) {
		
		this.comanda = comanda;
		System.out.println("teste"+this.comanda.getValorTotal());
		this.destinoSalvar = 	"caixa?faces-redirect=true";		
		return this.destinoSalvar ;
	}
	
	
	public void buscarComanda(){
		
		
	}
	

	@SuppressWarnings("static-access")
	public FormaPagamento[] getForma_pagamento() {
		return forma_pagamento.values();
	}

	public void setForma_pagamento(FormaPagamento forma_pagamento) {
		this.forma_pagamento = forma_pagamento;
	}

	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ItemComanda getItemComanda() {
		return itemComanda;
	}

	public void setItemComanda(ItemComanda itemComanda) {
		this.itemComanda = itemComanda;
	}

	public List<Produto> getProdutos() {
		if (this.Produtos == null) {
			this.Produtos = new ProdutoRN().listar();
		}
		return this.Produtos;
	}
	
	public Comanda getComanda() {		
		return this.comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	@SuppressWarnings("static-access")
	public EnumMovimentoCaixa[] getTipo_movimentacao() {
		return tipo_movimentacao.values();
	}

	public void setTipo_movimentacao(EnumMovimentoCaixa tipo_movimentacao) {
		this.tipo_movimentacao = tipo_movimentacao;
	}
	


	public List<ItemComanda> getItensComanda() {
		return itensComanda;
	}


	public void setItensComanda(List<ItemComanda> itensComanda) {
		this.itensComanda = itensComanda;
	}


	public String getDestinoSalvar() {
		return destinoSalvar;
	}


	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}


	public ItemComandaRN getItemComandaRN() {
		return itemComandaRN;
	}


	public void setItemComandaRN(ItemComandaRN itemComandaRN) {
		this.itemComandaRN = itemComandaRN;
	}


	public ComandaRN getComandaRN() {
		return comandaRN;
	}


	public void setComandaRN(ComandaRN comandaRN) {
		this.comandaRN = comandaRN;
	}


	public Long getId_comanda() {
		return id_comanda;
	}


	public void setId_comanda(Long id_comanda) {
		this.id_comanda = id_comanda;
	}


	public void setProdutos(List<Produto> produtos) {
		Produtos = produtos;
	}
	
	


}
