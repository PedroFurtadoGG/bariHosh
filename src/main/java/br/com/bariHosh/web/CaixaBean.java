package br.com.bariHosh.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.bariHosh.entidade.Caixa;
import br.com.bariHosh.entidade.Comanda;
import br.com.bariHosh.entidade.Despesa;
import br.com.bariHosh.entidade.EnumMovimentoCaixa;
import br.com.bariHosh.entidade.EnumStatusCaixa;
import br.com.bariHosh.entidade.EnumStatusComanda;
import br.com.bariHosh.entidade.EnumStatusPagamento;
import br.com.bariHosh.entidade.FormaPagamento;
import br.com.bariHosh.entidade.Movimentacao;
import br.com.bariHosh.entidade.Pagamento;
import br.com.bariHosh.negocio.CaixaRN;
import br.com.bariHosh.negocio.ComandaRN;
import br.com.bariHosh.util.ManuseioPublico;

@ManagedBean(name = "caixaBean")
@SessionScoped
public class CaixaBean implements Serializable {

	private static final long serialVersionUID = -6414690959254535730L;

	private FormaPagamento forma_pagamento;
	private EnumMovimentoCaixa tipo_movimentacao;
	private String destinoSalvar;

	private ComandaRN comandaRN = new ComandaRN();
	private Comanda comanda = new Comanda();
	private Caixa caixa = new Caixa();
	private CaixaRN caixaRN = new CaixaRN();
	private Despesa despesa = new Despesa();
	private Pagamento pagamento = new Pagamento();
	private Movimentacao movimentacao = new Movimentacao();
	private boolean painelCaixaRenderizado = false;
	public CaixaRN getCaixaRN() {
		return caixaRN;
	}

	public void setCaixaRN(CaixaRN caixaRN) {
		this.caixaRN = caixaRN;
	}

	public boolean isPainelCaixaRenderizado() {
		return painelCaixaRenderizado;
	}

	public void setPainelCaixaRenderizado(boolean painelCaixaRenderizado) {
		this.painelCaixaRenderizado = painelCaixaRenderizado;
	}

	private List<Movimentacao> movimentacoesCaixa = new ArrayList<Movimentacao>();

	@PostConstruct
	public void init() {
		System.out.println("entrou construtor");
		
		if(this.caixa.getId_caixa()==null) {
			//abrirCaixa();			
		}       
		Comanda comanda_encerrada = this.comandaRN.recuperaComandaParaEdicao("id_comanda_encerrada");
		if (comanda_encerrada != null) {
			this.comanda = comanda_encerrada;
			this.pagamento.setValorTotal(this.comanda.getValorTotal());
		}
	}

	public String novo() {
		this.pagamento = new Pagamento();
		this.comanda = new Comanda();
		this.comandaRN = new ComandaRN();
		this.despesa = new Despesa();
		this.destinoSalvar = "caixa";
		return this.destinoSalvar;
	}

	public String  abrirCaixa() {
		System.out.println("abriur");
		this.painelCaixaRenderizado =true;	  
		this.caixa.setMovimentacaoCaixa(this.movimentacoesCaixa);
		this.caixa.setData_abertura(new Date());
		this.caixa.setStatusCaixa(EnumStatusCaixa.ABERTO);
        return "caixa";
	}

	public void fechaCaixa() {
		System.out.println("abriur");
		this.painelCaixaRenderizado =false;
	    ManuseioPublico.MessagesSucesso("Caixa fechado ");
		this.caixa.setMovimentacaoCaixa(this.movimentacoesCaixa);
		this.caixa.setData_fechamento(new Date());
		this.caixa.setStatusCaixa(EnumStatusCaixa.FECHADO);
		
	}
	
	

	public void finalizarMovimentacaoComanda() {
        this.pagamento.setCompletamenteRecebido(true);
        this.pagamento.setStatusPagamento(EnumStatusPagamento.FINALIZADO);
        this.pagamento.setDespesa(new Despesa());
        this.pagamento.getDespesa().setValorTotalDespesa(this.comanda.getValorTotal());
        this.pagamento.getDespesa().setDataCricacaoDespesa(new Date());
        this.pagamento.getDespesa().setComanda(this.comanda);
        this.movimentacao.setDataInicialMovimentacao(new Date());
        this.movimentacao.setTipo_movimento(EnumMovimentoCaixa.EN);
        this.movimentacao.setDataFinalMovimentacao(new Date());
        this.movimentacao.setPagamentoComanda(this.pagamento);       
        this.caixa.adicionaMovimentacao(this.movimentacao);
        if(this.caixaRN.salvar(caixa)){         	
        	this.comanda.setStatusComanda(EnumStatusComanda.FINALIZADO);
        	new ComandaRN().atualiza(this.comanda);    
        	this.comanda = new Comanda();
        	this.pagamento=new Pagamento();
        	this.despesa=new Despesa();
        
        	ManuseioPublico.MessagesSucesso("Transação concluida com sucesso ");
        	ManuseioPublico.MessagesSucesso("Caixa Livre  ");
        }       
		
		
	}

	public void alteraValorTotalPagamento() {
		this.pagamento.setValorTotal(
				this.comanda.getValorTotal() + this.pagamento.getValorAcrescimo() - this.pagamento.getDesconto());

	}

	public String buscarComanda() {
		Comanda comandarecuperada = new ComandaRN().carregarComanda(this.comanda.getId_comanda());
		if (comandarecuperada != null) {
			this.comanda = comandarecuperada;
			this.pagamento.setValorTotal(this.comanda.getValorTotal());
		}
		return "caixa";
	}

	@SuppressWarnings("static-access")
	public FormaPagamento[] getForma_pagamento() {
		return forma_pagamento.values();
	}
	

	@SuppressWarnings("static-access")
	public FormaPagamento getForma_pagamentosel() {
		return forma_pagamento.DINHEIRO_VISTA;
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

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Movimentacao getMovimentacao() {
		return movimentacao;
	}

	public void setMovimentacao(Movimentacao movimentacao) {
		this.movimentacao = movimentacao;
	}

	public List<Movimentacao> getMovimentacoesCaixa() {
		return movimentacoesCaixa;
	}

	public void setMovimentacoesCaixa(List<Movimentacao> movimentacoesCaixa) {
		this.movimentacoesCaixa = movimentacoesCaixa;
	}
}
