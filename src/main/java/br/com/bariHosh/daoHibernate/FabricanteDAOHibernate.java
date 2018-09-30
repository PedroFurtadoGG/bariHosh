package br.com.bariHosh.daoHibernate;

import org.hibernate.Session;

import br.com.bariHosh.dao.FabricanteDAO;
import br.com.bariHosh.entidade.Fabricante;
import br.com.bariHosh.util.DAOFactory;

public class FabricanteDAOHibernate extends GenericoDAOHibernate<Fabricante> implements FabricanteDAO{

		private Session session = DAOFactory.PegarSession();
}
