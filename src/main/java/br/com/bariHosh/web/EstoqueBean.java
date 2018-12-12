package br.com.bariHosh.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.bariHosh.entidade.EnumTipoRegistro;
import br.com.bariHosh.entidade.Estoque;
import br.com.bariHosh.entidade.Log_Estoque;
import br.com.bariHosh.entidade.Produto;
import br.com.bariHosh.negocio.EstoqueRN;
import br.com.bariHosh.negocio.ProdutoRN;

@ManagedBean(name = "estoqueBean")
@RequestScoped
public class EstoqueBean {

	private Produto produto = new Produto();
	private Estoque estoque = new Estoque();
	private List<Produto> listaProdutos;
	private Log_Estoque logEstoque = new Log_Estoque();
	private EstoqueRN estoqueRN = new EstoqueRN();
	private ProdutoRN produtoRN = new ProdutoRN();
	private String destinoSalvar;
	private Integer LancamentoQuantia;
	private Date dataMovimentacao;
	private Estoque estoqueFiltro = new Estoque();
	private Produto produtoFiltro = new Produto();
	
	private List<Estoque> lista;

	private Integer quantidadeTotalprodutos;
	private EnumTipoRegistro enumRegistro;

	public EstoqueBean() {
		this.destinoSalvar = "produtos-estoque";
		this.setProduto(new Produto());
		this.estoque = new Estoque();
		this.estoque.setProduto(produto);
		
		this.setEstoqueFiltro(new Estoque());
		this.setEstoqueFiltro(estoqueFiltro);
		this.setProdutoFiltro(new Produto());
		this.estoqueFiltro = new Estoque();
		this.estoqueFiltro.setProduto(produtoFiltro);
	}
	
//	public EstoqueBean() {
//		this.produtoRN = new ProdutoRN();
//		this.destinoSalvar = "produtos-estoque";
//		this.produto.setEstoque(this.estoque);
//		// obterTotalProdutosEmEstoqueGeral();
//	}

	public String novo() {
		this.estoqueRN = new EstoqueRN();
		this.produto = new Produto();
		this.estoque = new Estoque();
		this.produto.setEstoque(estoque);
		this.estoque.setProduto(this.produto);
		this.listaProdutos = new ArrayList<Produto>();
		this.produtoRN = new ProdutoRN();
		this.dataMovimentacao = new Date();
		return "/restrito/estoque/estoque";
	}

	public String editar() {
		return "/restrito/estoque/estoque";
	}

	public String salvar() {
		if (estoqueRN.salvar(this.produto, this.logEstoque, this.LancamentoQuantia)) {
			this.listaProdutos = null;
			return this.destinoSalvar;
		}
		return null;

	}

	// este metodo es responsavel por trazer a quantidade total de itens(produto)
	// dentro do armazenbar
	public Integer obterTotalProdutosEmEstoqueGeral() {
		this.quantidadeTotalprodutos = estoqueRN.obterTotalProdutosEmEstoqueGeral();
		return this.quantidadeTotalprodutos;
	}
	
	public String filtrar() {

		this.lista = estoqueRN.listaFiltrada(estoqueFiltro.getProduto().getId_produto(), estoqueFiltro.getProduto().getNome(),
				estoqueFiltro.getProduto().getCodigo_barras());

		return "/restrito/estoque/produtos-estoque";
	}
	
	public List<Estoque> getLista() {
		if (this.lista == null) {

			this.lista = estoqueRN.listar();
		}
		return this.lista;
	}
	
	public void setLista(List<Estoque> lista) {
		this.lista = lista;
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
			this.listaProdutos = produtoRN.listarCompleto();
		}
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

	public Integer getQuantidadeTotalprodutos() {
		return quantidadeTotalprodutos;
	}

	public void setQuantidadeTotalprodutos(Integer quantidadeTotal) {
		this.quantidadeTotalprodutos = quantidadeTotal;
	}

	@SuppressWarnings("static-access")
	public EnumTipoRegistro[] getEnumRegistro() {
		return enumRegistro.values();
	}

	public void setEnumRegistro(EnumTipoRegistro enumRegistro) {
		this.enumRegistro = enumRegistro;
	}

	public Log_Estoque getLogEstoque() {
		return logEstoque;
	}

	public void setLogEstoque(Log_Estoque logEstoque) {
		this.logEstoque = logEstoque;
	}

	public Integer getLancamentoQuantia() {
		return LancamentoQuantia;
	}

	public void setLancamentoQuantia(Integer lancamentoQuantia) {
		LancamentoQuantia = lancamentoQuantia;
	}

	public Date getDataMovimentacao() {
		return dataMovimentacao;
	}

	public void setDataMovimentacao(Date dataMovimentacao) {
		this.dataMovimentacao = dataMovimentacao;
	}

	public Estoque getEstoqueFiltro() {
		return estoqueFiltro;
	}

	public void setEstoqueFiltro(Estoque estoqueFiltro) {
		this.estoqueFiltro = estoqueFiltro;
	}
	
	public Produto getProdutoFiltro() {
		return produtoFiltro;
	}

	public void setProdutoFiltro(Produto produtoFiltro) {
		this.produtoFiltro = produtoFiltro;
	}

}
