package br.com.bariHosh.daoHibernate;

import java.util.List;

import org.hibernate.Session;

import br.com.bariHosh.dao.EstoqueDAO;
import br.com.bariHosh.entidade.*;
import br.com.bariHosh.util.DAOFactory;

public class EstoqueDAOHibernate extends GenericoDAOHibernate<Estoque> implements EstoqueDAO {

	private Session session = DAOFactory.PegarSession();

	@Override
	public Estoque pegaEstoquePeloProduto(Produto produto) {
		
		return null;
	}

	@Override
	public List<Estoque> listaEstoqueCheio() {
		
		return null;
	}

	@Override
	public List<GrupoProduto> pegaListaGrupos() {
		// TODO Auto-generated method stub
		return null;
	}

}
