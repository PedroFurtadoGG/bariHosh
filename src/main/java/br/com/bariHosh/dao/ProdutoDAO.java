package br.com.bariHosh.dao;

import java.util.List;

import br.com.bariHosh.entidade.Produto;

public interface ProdutoDAO {
	
	public Produto pegaProdutoPeloCodBarras(String codiBarras);
	public List<Produto> listaDeprodutosEmEstoque();
	public Integer 	quantidadeEmEstoque();

}
