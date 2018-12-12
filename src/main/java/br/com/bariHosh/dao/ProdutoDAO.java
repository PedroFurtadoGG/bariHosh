package br.com.bariHosh.dao;

import java.util.Date;
import java.util.List;

import br.com.bariHosh.entidade.Produto;

public interface ProdutoDAO {
	
	public Produto pegaProdutoPeloCodBarras(String codiBarras);
	public List<Produto> listaDeprodutosEmEstoque();
	public Integer 	quantidadeEmEstoque();
	public List<Produto> listaCompleta();
	public List<Produto> listaFiltrada(String nome , Float valorEntrada, Float valorSaida , String codBarras);
	public List<Produto> listarProximosVencimentos();
	public String roshDisponiveis();
	
}
