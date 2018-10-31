package br.com.bariHosh.daoHibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.bariHosh.dao.AbstratoModeloDAO;
import br.com.bariHosh.util.DAOFactory;

public class GenericoDAOHibernate<T> implements AbstratoModeloDAO<T> {

	private Session session = DAOFactory.PegarSession();

	@Override
	public void salvar(T model) {
		try {
			this.session.save(model);
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void atualizar(T model) {
		try {
          
            this.session.merge(model);
			
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void excluir(T model) {
		try {

			this.session.delete(model);
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public T carregar(Class<?> clazz, Long id) {
		T padrao = (T) new Object();
		try {
			padrao = (T) this.session.get(clazz, id);
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		}
		return padrao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listar(Class<?> clazz) {
		List<T> lista = new ArrayList<T>();
		try {
			lista = this.session.createQuery(" FROM  " + clazz.getName()).list();
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		}
		return lista;

	}

}
