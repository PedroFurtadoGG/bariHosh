package br.com.bariHosh.web;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.bariHosh.entidade.Caixa;
import br.com.bariHosh.entidade.Movimentacao;
import br.com.bariHosh.negocio.MovimentacaoRN;

@ManagedBean(name = "movimentacaoBean")
@ViewScoped
public class MovimentacaoBean implements Serializable {

	private static final long serialVersionUID = -6414690959254535730L;
	private List<Movimentacao> listamovimentacoesCaixa ;
	private Movimentacao movimentacaoFiltro ;
	private String destinoSalvar;
	private Caixa caixaFiltro;
	
	

	
	@PostConstruct
	public void Init() {
		this.movimentacaoFiltro = new Movimentacao();
		this.caixaFiltro = new Caixa();
		this.movimentacaoFiltro.setCaixa(this.caixaFiltro);
		
		System.out.println("esta iniciando");
	}
	
	public String filtrar() {
		this.listamovimentacoesCaixa = new MovimentacaoRN().listaFiltrada(movimentacaoFiltro.getId_movimentacao(), movimentacaoFiltro.getCaixa().getId_caixa(),
				movimentacaoFiltro.getDataInicialMovimentacao(),movimentacaoFiltro.getDataFinalMovimentacao());
		     this.destinoSalvar= "movimentacaoCaixa" ;
		return this.destinoSalvar;
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
	
	
	
	public List<Movimentacao>   buscaPeloNomeUsuario(String nome) {
		List<Movimentacao> mov = new MovimentacaoRN().listaDeMovimentacoes();
		 mov.stream().filter(c -> c.getCaixa().getUsuarioCaixa().getPessoa().getNome().contains(nome)).collect(Collectors.toList());
		return mov;

	}

	public void excluirMovimentacao(Movimentacao mov) {

	}
	

	public List<Movimentacao> getListamovimentacoesCaixa() {	
		   if(this.listamovimentacoesCaixa ==null) {
			   this.listamovimentacoesCaixa = new MovimentacaoRN().listaDeMovimentacoes();			   
		   }
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

	public Caixa getCaixaFiltro() {
		return caixaFiltro;
	}

	public void setCaixaFiltro(Caixa caixaFiltro) {
		this.caixaFiltro = caixaFiltro;
	}

	
}
