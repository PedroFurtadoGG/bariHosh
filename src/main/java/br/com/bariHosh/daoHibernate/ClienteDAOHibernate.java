package br.com.bariHosh.daoHibernate;

import org.hibernate.Session;

import br.com.bariHosh.dao.ClienteDAO;
import br.com.bariHosh.entidade.*;
import br.com.bariHosh.util.DAOFactory;

public class ClienteDAOHibernate extends GenericoDAOHibernate<Cliente> implements ClienteDAO {

	private Session session = DAOFactory.PegarSession();

}
