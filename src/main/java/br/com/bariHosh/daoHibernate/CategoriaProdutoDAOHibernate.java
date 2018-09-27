package br.com.bariHosh.daoHibernate;

import org.hibernate.Session;

import br.com.bariHosh.dao.CategoriaProdutoDAO;
import br.com.bariHosh.entidade.CategoriaProduto;
import br.com.bariHosh.util.DAOFactory;

public class CategoriaProdutoDAOHibernate extends GenericoDAOHibernate<CategoriaProduto>
		implements CategoriaProdutoDAO {

	private Session session = DAOFactory.PegarSession();

}
