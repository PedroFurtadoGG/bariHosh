package br.com.bariHosh.dao;

import java.util.List;

import br.com.bariHosh.entidade.Estoque;
import br.com.bariHosh.entidade.Produto;

public interface EstoqueDAO {

	
	public Estoque pegaEstoquePeloProduto(Produto produto);
	public List<Estoque> listaEstoqueCheio();
}
