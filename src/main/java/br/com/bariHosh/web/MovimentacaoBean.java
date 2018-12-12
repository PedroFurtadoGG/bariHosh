package br.com.bariHosh.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.bariHosh.entidade.Movimentacao;
import br.com.bariHosh.negocio.MovimentacaoRN;

@ManagedBean(name = "movimentacaoBean")
@ViewScoped
public class MovimentacaoBean implements Serializable {

	private static final long serialVersionUID = -6414690959254535730L;
	private List<Movimentacao> listamovimentacoesCaixa = new ArrayList<Movimentacao>();
	private Movimentacao movimentacaoFiltro;
	private String destinoSalvar;
	private Long codigomovimentacao;
	private String nome;

	
	@PostConstruct
	public void Init() {System.out.println("entrou aqui ");
	    atualizaLista();
		
		System.out.println("esta iniciando");
	}
	
	public String novo() {

		return this.destinoSalvar;
	}

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

	public void visualizarMovimentacao(Movimentacao mov) {

	}

	public void excluirMovimentacao(Movimentacao mov) {

	}

	public void filtrarMovimentacao() {
		atualizaLista();
		System.out.println("tachegando");
		List<Movimentacao> lst = this.listamovimentacoesCaixa;
		this.listamovimentacoesCaixa = new ArrayList<Movimentacao>();
		this.listamovimentacoesCaixa.add( new MovimentacaoRN().filtro(lst, this.codigomovimentacao));

	}
	public void atualizaLista() {
		
			this.listamovimentacoesCaixa = new MovimentacaoRN().listaDeMovimentacoes();
		
		
	}

	public List<Movimentacao> getListamovimentacoesCaixa() {	
		return listamovimentacoesCaixa;
	}

	public void setListamovimentacoesCaixa(List<Movimentacao> listamovimentacoesCaixa) {
		this.listamovimentacoesCaixa = listamovimentacoesCaixa;
	}

	public Movimentacao getMovimentacaoFiltro() {
		return movimentacaoFiltro;
	}

	public void setMovimentacaoFiltro(Movimentacao movimentacaoFiltro) {
		this.movimentacaoFiltro = movimentacaoFiltro;
	}

	public Long getCodigomovimentacao() {
		return codigomovimentacao;
	}

	public void setCodigomovimentacao(Long codigomovimentacao) {
		this.codigomovimentacao = codigomovimentacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
