package br.com.bariHosh.daoHibernate;

import org.hibernate.Session;

import br.com.bariHosh.dao.PagamentoDAO;
import br.com.bariHosh.entidade.*;
import br.com.bariHosh.util.DAOFactory;

public class PagamentoDAOHibernate  extends GenericoDAOHibernate<Pagamento> 
        implements PagamentoDAO {
	
	  private Session session  = DAOFactory.PegarSession();

}
