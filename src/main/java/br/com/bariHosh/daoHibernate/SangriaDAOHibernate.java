package br.com.bariHosh.daoHibernate;

import org.hibernate.Session;

import br.com.bariHosh.dao.SangriaDAO;
import br.com.bariHosh.entidade.SangriaCaixa;
import br.com.bariHosh.util.DAOFactory;

public class SangriaDAOHibernate extends GenericoDAOHibernate<SangriaCaixa> implements SangriaDAO {

	
	private Session session = DAOFactory.PegarSession();
	
	
//	@Override
//	public Caixa recuperaCaixaAberto() {		
//		
//		String hql = "select c from Caixa c JOIN FETCH c.usuarioCaixa o  where c.statusCaixa = :status";
//		try {	
//		Query consulta = this.session.createQuery(hql);	
//		consulta.setParameter("status", EnumStatusCaixa.ABERTO);
//		return  (Caixa) consulta.uniqueResult(); 
//		}catch (HibernateException e) {
//			System.out.println("erro "+e.getMessage());
//			return null;
//		}
//		
//		
//	}

	
	

}
