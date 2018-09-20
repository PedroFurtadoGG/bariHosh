package br.com.bariHosh.daoHibernate;

import java.util.List;

import org.hibernate.Session;

import br.com.bariHosh.dao.AbstratoModeloDAO;
import br.com.bariHosh.util.DAOFactory;

public class GenericoDAOHibernate<T> implements AbstratoModeloDAO<T> {

	private Session session = DAOFactory.PegarSession();

	@Override
	public void salvar(T model) {
		this.session.save(model);

	}

	@Override
	public void atualizar(T model) {
		this.session.update(model);

	}

	@Override
	public void excluir(T model) {
		this.session.delete(model);

	}

	@SuppressWarnings("unchecked")
	@Override
	public T carregar(Long id) {
		return (T) this.session.get(Object.class, id);
	}

	@Override
	public List<T> listar(Class clazz) {
		return  this.session.createQuery("FROM"+ clazz.getName()).list();
		
	}

	

}
