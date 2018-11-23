package br.com.bariHosh.daoHibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.bariHosh.dao.EstoqueDAO;
import br.com.bariHosh.entidade.*;
import br.com.bariHosh.util.DAOFactory;

public class EstoqueDAOHibernate extends GenericoDAOHibernate<Estoque> implements EstoqueDAO {

	private Session session = DAOFactory.PegarSession();
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Estoque> ListaEstoqueVinculados(Long id_produto) {
		String hql = "select e from Estoque e where e.produto = :idproduto";
		Query consulta = this.session.createQuery(hql);
		consulta.setLong("idproduto", id_produto);
		List<Estoque> listaEstoque = new ArrayList<Estoque>();
		   listaEstoque = consulta.list();
		return listaEstoque ;
		
		
	}

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
		return null;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}
