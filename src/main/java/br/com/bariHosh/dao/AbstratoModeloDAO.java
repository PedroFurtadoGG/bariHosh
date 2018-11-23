package br.com.bariHosh.dao;
import java.util.List;

public interface AbstratoModeloDAO<T> {
	
	public void salvar(T model);

	public void atualizar(T model);

	public void excluir(T model);	

	public List<T> listar(Class<?> clazz);

	public T carregar(Class<?> clazz, Long id);



	
}
