package br.com.bariHosh.dao;

import java.util.List;

import br.com.bariHosh.entidade.*;

public interface PessoaDAO {
	
	public Pessoa buscarPorLogin(String login);
	public Pessoa buscarPorTipo(String tipo);
	public List<Pessoa> listaPessoasUsuario();
}
