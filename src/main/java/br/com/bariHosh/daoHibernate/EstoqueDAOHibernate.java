package br.com.bariHosh.daoHibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.bariHosh.dao.EstoqueDAO;
import br.com.bariHosh.entidade.Estoque;
import br.com.bariHosh.entidade.GrupoProduto;
import br.com.bariHosh.entidade.Produto;
import br.com.bariHosh.util.DAOFactory;
import br.com.bariHosh.util.ManuseioPublico;

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
		return listaEstoque;

	}

	@Override
	public Estoque pegaEstoquePeloProduto(Produto produto) {
		String hql = "select e from Estoque e where e.produto = :idproduto and  e.ativo =1";
		Query consulta = this.session.createQuery(hql);
		consulta.setLong("idproduto", produto.getId_produto());
		Estoque estoque = (Estoque) consulta.uniqueResult();
		return estoque;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Estoque> listaFiltrada(Long id_produto, String nome, String barra) {
		StringBuffer hql = new StringBuffer();

		hql.append("select e from Estoque e LEFT JOIN FETCH e.produto p where 1=1 ");

		if (ManuseioPublico.validaObjeto(id_produto)) {
			hql.append(" and p.id_produto = " + id_produto + "");
		}

		if (ManuseioPublico.validaObjeto(nome)) {
			hql.append(" and p.nome like '%" + nome + "%' ");
		}

		if (ManuseioPublico.validaObjeto(barra)) {
			hql.append(" and p.codigo_barras = '%" + barra + "%'");
		}

		Query consulta = this.session.createQuery(hql.toString());
		List<Estoque> listaFiltrada = (List<Estoque>) consulta.list();

		return listaFiltrada;
	}

}
