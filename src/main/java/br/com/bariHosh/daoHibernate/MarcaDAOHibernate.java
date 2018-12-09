package br.com.bariHosh.daoHibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.bariHosh.dao.MarcaDAO;
import br.com.bariHosh.entidade.Marca;
import br.com.bariHosh.entidade.Produto;
import br.com.bariHosh.util.DAOFactory;
import br.com.bariHosh.util.ManuseioPublico;

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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Marca> listaCompleta() {
		String hql = "select m from Marca m  "
				+ " JOIN FETCH m.fabricante f " ;				
		Query consulta = this.session.createQuery(hql);
		List<Marca> list = (List<Marca> ) consulta.list();
		
		return list;		
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Marca> listaFiltrada(Long id_marca, String nome) {
		StringBuffer hql = new StringBuffer();

		hql.append("select c from Marca c LEFT JOIN FETCH c.pessoa p  ");
		hql.append(" where p.nome like '%" + nome + "%' ");



		if (!ManuseioPublico.validaObjeto(id_marca)) {
			hql.append(" and c.id_marca = " + id_marca + " ");
		}

		Query consulta = this.session.createQuery(hql.toString());
		List<Marca> listaFiltrada = (List<Marca>) consulta.list();
		
		return listaFiltrada;
	}
}
