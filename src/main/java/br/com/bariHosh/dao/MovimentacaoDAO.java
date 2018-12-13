package br.com.bariHosh.dao;

import java.util.Date;
import java.util.List;

import br.com.bariHosh.entidade.Movimentacao;

public interface MovimentacaoDAO {

	public List<Movimentacao> listaFiltrada(Long id_movimentacao, Long id_caixa, Date dataInicialMovimentacao, Date dataFinalMovimentacao);

}
