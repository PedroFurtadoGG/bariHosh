package br.com.bariHosh.util;

import org.hibernate.Session;

public class DAOFactory {

	public static Session PegarSession() {		
		return  HibernateUtil.getSessionFactory().getCurrentSession();
	}
}
