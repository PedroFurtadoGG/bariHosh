package br.com.bariHosh.dao;

import java.util.List;

import br.com.bariHosh.entidade.Estoque;
import br.com.bariHosh.entidade.GrupoProduto;
import br.com.bariHosh.entidade.Produto;

public interface EstoqueDAO {

	
	public Estoque pegaEstoquePeloProduto(Produto produto);
	public List<Estoque> listaEstoqueCheio();
	public List<GrupoProduto> pegaListaGrupos();
	public List<Estoque> ListaEstoqueVinculados(Long id_produto);
	List<Estoque> listaFiltrada(Long id_produto, String nome, String barra);
	
}
