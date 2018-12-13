package br.com.bariHosh.dao;

import java.util.List;

import br.com.bariHosh.entidade.Caixa;

public interface CaixaDAO {

	public Caixa recuperaCaixaAberto();
	
	public List<Caixa> listarMovimentacoes(String tipoMovimentacao);
	public String totalMovimentacoes(String tipoMovimentacao);

}
