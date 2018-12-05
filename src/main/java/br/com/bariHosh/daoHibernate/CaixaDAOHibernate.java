package br.com.bariHosh.daoHibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.bariHosh.dao.CaixaDAO;
import br.com.bariHosh.entidade.Caixa;
import br.com.bariHosh.util.DAOFactory;

public class CaixaDAOHibernate extends GenericoDAOHibernate<Caixa> implements CaixaDAO {
	
	private Session session = DAOFactory.PegarSession();
	@SuppressWarnings("unchecked")
	@Override
	public List<Caixa> listarMovimentacoes(String tipo) {
		StringBuffer hql = new StringBuffer ();
		
		hql.append("select c from Caixa c left join fetch c.forma_pagamento fp ");
		hql.append(" where fp.chave = '" + tipo +"' ");
		hql.append(" order by c.data_movimentacao desc ");
		
		Query consulta = this.session.createQuery(hql.toString());
		List<Caixa> lista = (List<Caixa>)consulta.list();
		return lista;
	}
	@Override
	public String totalMovimentacoes(String tipoMovimentacao) {
		StringBuffer hql = new StringBuffer ();
		
		hql.append("select sum(c.valor_total) from Caixa c left join fetch c.forma_pagamento fp ");
		hql.append(" where fp.chave = '" + tipoMovimentacao +"' ");
		
		Query consulta = this.session.createQuery(hql.toString());
		String valorTotal = consulta;
		return valorTotal;
	}

	
	

}
