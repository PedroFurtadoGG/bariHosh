package br.com.bariHosh.dao;

import java.util.List;

public interface GenericDAO<T> {
	public void salvar(T model);

	public void atualizar(T model);

	public void excluir(T model);

	public T carregar(Integer id);

	public List<T> listar();
}
