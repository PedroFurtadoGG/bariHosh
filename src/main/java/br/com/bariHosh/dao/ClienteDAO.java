package br.com.bariHosh.dao;

import java.util.List;

import br.com.bariHosh.entidade.Cliente;

public interface ClienteDAO {
	
	public List<Cliente> listaFiltrada(String nome, String cpf, Long id_cliente);

}
