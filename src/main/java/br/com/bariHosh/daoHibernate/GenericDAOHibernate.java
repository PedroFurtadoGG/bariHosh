package br.com.bariHosh.daoHibernate;

import java.util.List;

import org.hibernate.Session;

import br.com.bariHosh.dao.GenericDAO;
import br.com.bariHosh.util.DAOFactory;

public class GenericDAOHibernate<T>   implements GenericDAO<T> {

	
 private Session session  = DAOFactory.PegarSession();  
	@Override
	public void salvar(T model) {
		this.session.save(model);
		
	}

	@Override
	public void atualizar(T model) {
		this.session.save(model);
		
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
	public List<T> listar() {
		return (List<T>) this.session.createCriteria(Object.class).list();
	}

}
