package br.com.bariHosh.daoHibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.bariHosh.dao.CategoriaProdutoDAO;
import br.com.bariHosh.entidade.CategoriaProduto;
import br.com.bariHosh.entidade.Produto;
import br.com.bariHosh.util.DAOFactory;

public class CategoriaProdutoDAOHibernate extends GenericoDAOHibernate<CategoriaProduto>
		implements CategoriaProdutoDAO {

	private Session session = DAOFactory.PegarSession();

	@Override
	public List<Produto> ListaProdutosVinculados(Long id) {
		String hql = "select p from Produto p where p.categoria = :idcategoria";
		Query consulta = this.session.createQuery(hql);
		consulta.setLong("idcategoria", id);
		List<Produto> listaProduto = new ArrayList<Produto>();
		   listaProduto = consulta.list();
		return listaProduto ;
	}

}
