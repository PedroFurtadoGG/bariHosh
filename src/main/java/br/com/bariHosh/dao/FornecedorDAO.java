package br.com.bariHosh.dao;

import java.util.List;

import br.com.bariHosh.entidade.*;

public interface FornecedorDAO {

	
	public Fornecedor buscarPorLogin(String login);
	public List<Fornecedor> listaFornecedores();
	public List<Produto> ListaProdutosVinculados(Long id);
}
