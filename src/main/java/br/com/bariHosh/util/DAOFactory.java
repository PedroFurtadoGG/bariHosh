package br.com.bariHosh.util;

import org.hibernate.Session;

import br.com.bariHosh.dao.UsuarioDAO;
import br.com.bariHosh.daoHibernate.UsuarioDAOHibernate;

public class DAOFactory {

	public static Session PegarSession() {		
		return  HibernateUtil.getSessionFactory().getCurrentSession();
	}
	
	public static UsuarioDAO criarUsuarioDAO() {
		UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO;
	}
}
