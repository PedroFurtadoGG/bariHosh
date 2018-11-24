package br.com.bariHosh.daoHibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.mysql.jdbc.PreparedStatement;

import br.com.bariHosh.dao.ProdutoDAO;
import br.com.bariHosh.entidade.Produto;
import br.com.bariHosh.util.DAOFactory;

public class ProdutoDAOHibernate extends GenericoDAOHibernate<Produto> implements ProdutoDAO {

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
		String hql = "select p from Produto p  " + " JOIN FETCH p.categoria c " + "JOIN FETCH p.marca_produto m"
				+ " JOIN FETCH p.fornecedor f" + " JOIN FETCH p.estoque e ";
		Query consulta = this.session.createQuery(hql);
		List<Produto> list = (List<Produto>) consulta.list();

		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> listaFiltrada(String nome, Float valorEntrada, Float valorSaida, String codBarras) {
		
		if(valorEntrada ==null) {
			valorEntrada = new Float(0.0);
		}
		if(valorSaida ==null) {
			valorSaida= new Float(0.0);
		}
		StringBuffer hql = new StringBuffer();
		hql.append("	select p from Produto p  where p.nome like '%" + nome +"%' ");
		if(valorEntrada>0.0) {
			hql.append("	and p.valorEntrada =" + valorEntrada);
		}
		if(valorSaida>0.0) {
			hql.append("	and p.valorSaida =" + valorSaida);
		}
		
		if(!codBarras.equals("")) {
			hql.append("	and p.codigo_barras like '%" + codBarras +"%'");
		}
		
		Query consulta = this.session.createQuery(hql.toString());
		List<Produto> listaFiltrada = (List<Produto>) consulta.list();
		return listaFiltrada;
	}


	
}
