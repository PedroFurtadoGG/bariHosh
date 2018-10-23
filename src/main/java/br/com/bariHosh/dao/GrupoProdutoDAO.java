package br.com.bariHosh.dao;

import java.util.Date;
import java.util.List;

import br.com.bariHosh.entidade.*;

public interface GrupoProdutoDAO {
	
	public List<Produto> listaProdutoPorGrupo();
	public Integer pegaQtdProduto();
	public GrupoProduto pegaGrupoPeloProduto(Produto produto);
	public List<Produto> listaProdutoValidade(Date data);
	public void adicionaProdutoAoGrupo(Produto produto);
	public void retiraProdutoDoGrupo(Produto produto);
	

}
