package br.com.bariHosh.daoHibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.bariHosh.dao.MarcaDAO;
import br.com.bariHosh.entidade.*;
import br.com.bariHosh.util.DAOFactory;

public class MarcaDAOHibernate  extends GenericoDAOHibernate<Marca>  implements MarcaDAO{
	
	  private Session session  = DAOFactory.PegarSession();

	@Override
	public List<Produto> ListaProdutosVinculados(Long id) {
		String hql = "select p from Produto p where p.marca_produto = :idmarca";
		Query consulta = this.session.createQuery(hql);
		consulta.setLong("idmarca", id);
		List<Produto> listaProduto = new ArrayList<Produto>();
		   listaProduto = consulta.list();
		return listaProduto ;
	}

}
