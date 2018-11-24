package br.com.bariHosh.daoHibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.bariHosh.dao.FornecedorDAO;
import br.com.bariHosh.entidade.Fornecedor;
import br.com.bariHosh.entidade.Produto;
import br.com.bariHosh.util.DAOFactory;

public class FornecedorDAOHibernate extends GenericoDAOHibernate<Fornecedor> implements FornecedorDAO {

	private Session session = DAOFactory.PegarSession();

	@Override
	public Fornecedor buscarPorLogin(String login) {
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Fornecedor> listaFornecedores(){
		
	  return session.createCriteria(Fornecedor.class).list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> ListaProdutosVinculados(Long id) {
		String hql = "select p from Produto p where p.fornecedor = :idfornecedor";
		Query consulta = this.session.createQuery(hql);
		consulta.setLong("idfornecedor", id);
		List<Produto> listaProduto = new ArrayList<Produto>();
		   listaProduto = consulta.list();
		return listaProduto ;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fornecedor> listaFiltrada(String numInscricao, String ramoAtividade, String razao) {
		StringBuffer hql = new StringBuffer();
		
		hql.append("select f from Fornecedor f");
		hql.append(" where f.ramoAtividade like '%" +ramoAtividade +"%' ");
		if(!numInscricao.equals("")) {
			hql.append("and f.numInscricao ='" + numInscricao +"'");
		}
		if(!razao.equals("")) {
			hql.append(" and f.razao like '%" + razao+ "%'");
		}
		
		Query consulta = this.session.createQuery(hql.toString());
		List<Fornecedor> listaFiltrada = (List<Fornecedor>)consulta.list();
		
		
		return listaFiltrada;
	}

}
