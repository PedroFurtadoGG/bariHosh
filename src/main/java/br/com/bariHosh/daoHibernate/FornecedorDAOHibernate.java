package br.com.bariHosh.daoHibernate;

import org.hibernate.Session;

import br.com.bariHosh.dao.FornecedorDAO;
import br.com.bariHosh.entidade.Fornecedor;
import br.com.bariHosh.util.DAOFactory;

public class FornecedorDAOHibernate extends GenericoDAOHibernate<Fornecedor> implements FornecedorDAO {

	private Session session = DAOFactory.PegarSession();

	@Override
	public Fornecedor buscarPorLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

}
