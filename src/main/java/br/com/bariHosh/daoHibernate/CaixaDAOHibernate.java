package br.com.bariHosh.daoHibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import br.com.bariHosh.dao.CaixaDAO;
import br.com.bariHosh.entidade.Caixa;
import br.com.bariHosh.entidade.EnumStatusCaixa;
import br.com.bariHosh.util.DAOFactory;

public class CaixaDAOHibernate extends GenericoDAOHibernate<Caixa> implements CaixaDAO {
	
	private Session session = DAOFactory.PegarSession();
	@SuppressWarnings("unchecked")
	@Override
	public List<Caixa> listarMovimentacoes(String tipoMovimentacao) {
		String hql = "SELECT movimentacao.id_movimentacao, movimentacao.id_caixa, movimentacao.tipo_movimento, movimentacao.dataFinalMovimentacao as data_movimentacao, movimentacao.id_pagamento, pagamento.ValorTotal as valor_total, pagamento.completamente_recebido " + 
				"				FROM movimentacao LEFT JOIN pagamento ON pagamento.id = movimentacao.id_pagamento " + 
				"				LEFT JOIN caixa ON caixa.id_caixa = movimentacao.id_caixa " + 
				"				WHERE movimentacao.tipo_movimento = '"+tipoMovimentacao+"' " +
				"               ORDER BY movimentacao.dataFinalMovimentacao DESC LIMIT 10";
		
		Query consulta = this.session.createSQLQuery(hql);
		consulta.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List<Caixa> lista = (List<Caixa>)consulta.list();
		return lista;
	}
	
	
	@Override
	public String totalMovimentacoes(String tipoMovimentacao) {
		String hql = "SELECT  ROUND(SUM(pagamento.ValorTotal), 2) FROM movimentacao LEFT JOIN pagamento ON movimentacao.id_pagamento = pagamento.id " + 
				" WHERE " + 
				" movimentacao.tipo_movimento = '"+tipoMovimentacao+"'";
		
		Query consulta = this.session.createSQLQuery(hql);
		String valorTotal = consulta.uniqueResult().toString();
		return valorTotal;
	}

	@Override
	public Caixa recuperaCaixaAberto() {		
		
		String hql = "select c from Caixa c JOIN FETCH c.usuarioCaixa o  where c.statusCaixa = :status";
		try {	
		Query consulta = this.session.createQuery(hql);	
		consulta.setParameter("status", EnumStatusCaixa.ABERTO);
		return  (Caixa) consulta.uniqueResult(); 
		}catch (HibernateException e) {
			System.out.println("erro "+e.getMessage());
			return null;
		}
		
		
	}

	
	

}
