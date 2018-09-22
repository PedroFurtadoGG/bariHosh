package br.com.bariHosh.dao;
import java.util.List;

public interface AbstratoModeloDAO<T> {
	
	public void salvar(T model);

	public void atualizar(T model);

	public void excluir(T model);

	public T carregar(Long id);	
	

	public List<T> listar(Class<?> clazz);

	
}
