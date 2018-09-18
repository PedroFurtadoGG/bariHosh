package br.com.bariHosh.daoHibernate;

import org.hibernate.Session;

import br.com.bariHosh.dao.MarcaDAO;
import br.com.bariHosh.entidade.*;
import br.com.bariHosh.util.DAOFactory;

public class MarcaDAOHibernate  extends GenericoDAOHibernate<Marca> 
       implements MarcaDAO{
	
	  private Session session  = DAOFactory.PegarSession();

}
