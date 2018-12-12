package br.com.bariHosh.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.bariHosh.entidade.Caixa;
import br.com.bariHosh.entidade.Cliente;
import br.com.bariHosh.entidade.Comanda;
import br.com.bariHosh.entidade.Produto;
import br.com.bariHosh.negocio.CaixaRN;
import br.com.bariHosh.negocio.ClienteRN;
import br.com.bariHosh.negocio.ComandaRN;
import br.com.bariHosh.negocio.ProdutoRN;

@ManagedBean(name="dashBean")
@ViewScoped
public class DashboardBean  {
	

	private Cliente cliente = new Cliente();
	private Produto produto = new Produto();
	private Caixa caixa = new Caixa();
	private Comanda comanda = new Comanda();

	private ClienteRN clienteRN = new ClienteRN();
	private ProdutoRN produtoRN = new ProdutoRN();
	private CaixaRN caixaRN = new CaixaRN();
	private ComandaRN comandaRN = new ComandaRN();
	
	private List<Caixa> listaCaixaEN;
	private List<Caixa> listaCaixaSA;
	private List<Comanda> listaComanda;
	private List<Produto> listaProdutosVencendo;
	
	String clientesCadastrados;
	String totalMovimentacoesEN;
	String totalMovimentacoesSA;
	String roshDisponiveis;
	
	
	
	public List<Caixa> getListaCaixaEN() {
		if(this.listaCaixaEN==null) {
			this.listaCaixaEN =  caixaRN.listarMovimentacoes("EN");
		}
		return this.listaCaixaEN;
	}


	public void setListaCaixaEN(List<Caixa> listaCaixaEN) {
		this.listaCaixaEN = listaCaixaEN;
	}


	public List<Caixa> getListaCaixaSA() {
		if(this.listaCaixaSA == null) {
			this.listaCaixaSA = caixaRN.listarMovimentacoes("SA");
			
		}
		return this.listaCaixaSA;
	}


	public void setListaCaixaSA(List<Caixa> listaCaixaSA) {
		this.listaCaixaSA = listaCaixaSA;
	}


	public List<Comanda> getListaComanda() {
		if(this.listaComanda==null) {
			this.listaComanda = comandaRN.listaComandasStatus(true);
		}
		return this.listaComanda;
	}


	public void setListaComanda(List<Comanda> listaComanda) {
		this.listaComanda = listaComanda;
	}


	
	public List<Produto> getListaProdutosVencendo() {
		if(this.listaProdutosVencendo == null) {
			this.listaProdutosVencendo =  produtoRN.listarProximosVencimentos();
		}
		return this.listaProdutosVencendo;
	}


	public void setListaProdutosVencendo(List<Produto> listaProdutosVencendo) {
		this.listaProdutosVencendo = listaProdutosVencendo;
	}


	public String getClientesCadastrados() {
		return this.clientesCadastrados = clienteRN.totalClientesRegistrados();
	}


	public void setClientesCadastrados(String clientesCadastrados) {
		this.clientesCadastrados = clientesCadastrados;
	}


	public String getTotalMovimentacoesEN() {
//		return this.totalMovimentacoesEN = new CaixaRN().totalMovimentacoes("EN");
		return this.totalMovimentacoesEN = caixaRN.totalMovimentacoes("EN");
	}


	public void setTotalMovimentacoesEN(String totalMovimentacoesEN) {
		this.totalMovimentacoesEN = totalMovimentacoesEN;
	}


	public String getTotalMovimentacoesSA() {
//		return this.totalMovimentacoesSA = new CaixaRN().totalMovimentacoes("SA");
		return this.totalMovimentacoesEN = caixaRN.totalMovimentacoes("SA");
	}


	public void setTotalMovimentacoesSA(String totalMovimentacoesSA) {
		this.totalMovimentacoesSA = totalMovimentacoesSA;
	}
	
	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	public Caixa getCaixa() {
		return caixa;
	}


	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}


	public Comanda getComanda() {
		return comanda;
	}


	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}


	public String getRoshDisponiveis() {
		return this.produtoRN.roshDisponiveis();
	}


	public void setRoshDisponiveis(String roshDisponiveis) {
		this.roshDisponiveis = roshDisponiveis;
	}
	
	


}
