package br.com.bariHosh.daoHibernate;

import java.util.List;

import org.hibernate.Session;

import br.com.bariHosh.dao.FornecedorDAO;
import br.com.bariHosh.entidade.Fornecedor;
import br.com.bariHosh.util.DAOFactory;

public class FornecedorDAOHibernate extends GenericoDAOHibernate<Fornecedor> implements FornecedorDAO {

	private Session session = DAOFactory.PegarSession();

	@Override
	public Fornecedor buscarPorLogin(String login) {
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Fornecedor> listaFornecedores(){
		
	  return session.createCriteria(Fornecedor.class).list();
	}

}
