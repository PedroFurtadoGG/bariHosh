package br.com.bariHosh.dao;

import java.util.List;

import br.com.bariHosh.entidade.Log_Estoque;

public interface LogEstoqueDAO {
	
	public List<Log_Estoque> ListaEtoqueVinculados(Long id_estoque);
		
		
	

}
