package br.com.bariHosh.daoHibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.bariHosh.dao.CategoriaProdutoDAO;
import br.com.bariHosh.entidade.CategoriaProduto;
import br.com.bariHosh.entidade.Produto;
import br.com.bariHosh.util.DAOFactory;
import br.com.bariHosh.util.ManuseioPublico;

public class CategoriaProdutoDAOHibernate extends GenericoDAOHibernate<CategoriaProduto>
		implements CategoriaProdutoDAO {

	private Session session = DAOFactory.PegarSession();

	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> ListaProdutosVinculados(Long id) {
		String hql = "select p from Produto p where p.categoria = :idcategoria";
		Query consulta = this.session.createQuery(hql);
		consulta.setLong("idcategoria", id);
		List<Produto> listaProduto = new ArrayList<Produto>();
		   listaProduto = consulta.list();
		return listaProduto ;
	}

	public List<CategoriaProduto> listaFiltrada(String descricao, Long id_categoria) {
		StringBuffer hql = new StringBuffer();

		hql.append("select c from CategoriaProduto c where 1=1 ");
		
		if(ManuseioPublico.validaObjeto(descricao)) {
			hql.append(" and c.descricao like '%" + descricao + "%' ");
		}


		if (ManuseioPublico.validaObjeto(id_categoria)) {
			hql.append("and c.id_categoria = " + id_categoria + " ");
		}

		Query consulta = this.session.createQuery(hql.toString());
		@SuppressWarnings("unchecked")
		List<CategoriaProduto> listaFiltrada = (List<CategoriaProduto>) consulta.list();
		
		return listaFiltrada;
	}
	
	

}
