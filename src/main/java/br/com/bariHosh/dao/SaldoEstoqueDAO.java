package br.com.bariHosh.dao;

import br.com.bariHosh.entidade.Produto;

public interface SaldoEstoqueDAO {
	
	public Integer pegaSaldoEstoque(Produto produto);
	public void adicionaQuantidadeAoEStoque();

}
