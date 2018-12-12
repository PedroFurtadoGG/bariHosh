package br.com.bariHosh.dao;

import br.com.bariHosh.entidade.Caixa;

public interface CaixaDAO {

	public Caixa recuperaCaixaAberto();
	
	public List<Caixa> listarMovimentacoes(String tipoMovimentacao);
	public String totalMovimentacoes(String tipoMovimentacao);

}
