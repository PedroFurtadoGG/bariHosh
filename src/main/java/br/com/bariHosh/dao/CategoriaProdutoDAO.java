package br.com.bariHosh.dao;

import java.util.List;

import br.com.bariHosh.entidade.Produto;

public interface CategoriaProdutoDAO {

	public List<Produto> ListaProdutosVinculados(Long id);
}
