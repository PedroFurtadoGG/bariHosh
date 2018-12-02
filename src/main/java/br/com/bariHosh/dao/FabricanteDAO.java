package br.com.bariHosh.dao;

import java.util.List;

import br.com.bariHosh.entidade.Fabricante;

public interface FabricanteDAO {
	
	public List<Fabricante> listaFiltrada(Long id_fabricante, String razaoSocial);
}
