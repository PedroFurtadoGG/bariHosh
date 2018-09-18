package br.com.bariHosh.daoHibernate;

import java.util.List;

import org.hibernate.Session;

import br.com.bariHosh.dao.ProdutoDAO;
import br.com.bariHosh.entidade.*;
import br.com.bariHosh.util.DAOFactory;

public class ProdutoDAOHibernate extends GenericoDAOHibernate<Produto> implements ProdutoDAO {
	private Session session = DAOFactory.PegarSession();

	@Override
	public Produto pegaProdutoPeloCodBarras(String codiBarras) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> listaDeprodutosEmEstoque() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer quantidadeEmEstoque() {
		// TODO Auto-generated method stub
		return null;
	}

}
