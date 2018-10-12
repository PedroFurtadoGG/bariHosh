package br.com.bariHosh.daoHibernate;

import java.util.List;

import org.hibernate.Session;

import br.com.bariHosh.dao.PessoaDAO;
import br.com.bariHosh.entidade.*;
import br.com.bariHosh.util.DAOFactory;

public class PessoaDAOHibernate extends GenericoDAOHibernate<Pessoa> implements PessoaDAO {

	@SuppressWarnings("unused")
	private Session session = DAOFactory.PegarSession();

	@Override
	public Pessoa buscarPorLogin(String login) {
		
		return null;
	}

	@Override
	public Pessoa buscarPorTipo(String tipo) {
		
		return null;
	}

	@Override
	public List<Pessoa> listaPessoasUsuario() {
		
		return null;
	}

}
