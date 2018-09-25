package br.com.bariHosh.daoHibernate;

import org.hibernate.Session;

import br.com.bariHosh.dao.LogEstoqueDAO;
import br.com.bariHosh.entidade.*;
import br.com.bariHosh.util.DAOFactory;

public class LogEstoqueDAOHibernate extends GenericoDAOHibernate<Log_Estoque>  
      implements LogEstoqueDAO{
    	  
    	  private Session session  = DAOFactory.PegarSession();

}
