package br.com.bariHosh.daoHibernate;

import java.util.List;

import org.hibernate.Session;

import br.com.bariHosh.dao.PessoaDAO;
import br.com.bariHosh.entidade.*;
import br.com.bariHosh.util.DAOFactory;

public class PessoaDAOHibernate extends GenericoDAOHibernate<Pessoa> implements PessoaDAO {

	private Session session = DAOFactory.PegarSession();

	@Override
	public Pessoa buscarPorLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pessoa buscarPorTipo(String tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pessoa> listaPessoasUsuario() {
		// TODO Auto-generated method stub
		return null;
	}

}
