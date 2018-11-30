package br.com.bariHosh.web;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.bariHosh.entidade.Caixa;
import br.com.bariHosh.entidade.Comanda;
import br.com.bariHosh.entidade.Despesa;
import br.com.bariHosh.entidade.EnumMovimentoCaixa;
import br.com.bariHosh.entidade.FormaPagamento;
import br.com.bariHosh.entidade.Pagamento;
import br.com.bariHosh.negocio.ComandaRN;

@ManagedBean(name = "caixaBean")
@ViewScoped
public class CaixaBean implements Serializable {

	private static final long serialVersionUID = -6414690959254535730L;

	private FormaPagamento forma_pagamento;
	private EnumMovimentoCaixa tipo_movimentacao;
	private String destinoSalvar;
	private ComandaRN comandaRN = new ComandaRN();
	

	private Comanda comanda = new Comanda();
	private Caixa caixa = new Caixa();
	private Despesa despesa = new Despesa();
	
	private Pagamento pagamento = new Pagamento();
	
	@PostConstruct
	public void Init() {
		this.pagamento.setDespesa(this.despesa);
		
		
	}
	

	public Pagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	@PostConstruct
	public void init() {
		Comanda comanda_encerrada = this.comandaRN.recuperaComandaParaEdicao("id_comanda_encerrada");
		if (comanda_encerrada != null) {
			this.comanda = comanda_encerrada;
		}
	}
	public String novo() {

		
		return "comanda";
	}

	public String realizarPagamendo(Comanda comanda) {

		this.comanda = comanda;
		System.out.println("teste" + this.comanda.getValorTotal());
		this.destinoSalvar = "caixa?faces-redirect=true";
		return this.destinoSalvar;
	}
	
	
	public String finalizarMovimentacaoComanda() {		
		System.out.println("teste" + this.comanda.getValorTotal());
		this.destinoSalvar = "caixa?faces-redirect=true";
		return this.destinoSalvar;
	}

	public void buscarComanda() {
		Comanda comandarecuperada = new ComandaRN().carregarComanda(this.comanda.getId_comanda());
		if(comandarecuperada!=null) {
		this.comanda = comandarecuperada;
		}        
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

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

	public ComandaRN getComandaRN() {
		return comandaRN;
	}

	public void setComandaRN(ComandaRN comandaRN) {
		this.comandaRN = comandaRN;
	}

	public Despesa getDespesa() {
		return despesa;
	}
	public void setDespesa(Despesa despesa) {
		this.despesa = despesa;
	}
}
