package br.com.bariHosh.daoHibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.bariHosh.dao.ProdutoDAO;
import br.com.bariHosh.entidade.*;
import br.com.bariHosh.util.DAOFactory;

public class ProdutoDAOHibernate extends GenericoDAOHibernate<Produto> implements ProdutoDAO {
	@SuppressWarnings("unused")
	private Session session = DAOFactory.PegarSession();

	@Override
	public Produto pegaProdutoPeloCodBarras(String codiBarras) {

		return null;
	}

	@Override
	public List<Produto> listaDeprodutosEmEstoque() {

		return null;
	}

	@Override
	public Integer quantidadeEmEstoque() {

		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> listaCompleta() {
		String hql = "select p from Produto p  "
				+ " JOIN FETCH p.categoria c "
			 	+ "JOIN FETCH p.marca_produto m"
				+ " JOIN FETCH p.fornecedor f"
				+ " JOIN FETCH p.estoque e "
				+ " JOIN FETCH p.usuario_criador u " ;				
		Query consulta = this.session.createQuery(hql);
		List<Produto> list = (List<Produto> ) consulta.list();
		
		return list;		
	}

}
