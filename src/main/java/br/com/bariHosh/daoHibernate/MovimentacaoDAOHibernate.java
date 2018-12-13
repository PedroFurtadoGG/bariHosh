package br.com.bariHosh.daoHibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.bariHosh.dao.MovimentacaoDAO;
import br.com.bariHosh.entidade.Movimentacao;
import br.com.bariHosh.util.DAOFactory;
import br.com.bariHosh.util.ManuseioPublico;

public class MovimentacaoDAOHibernate  extends GenericoDAOHibernate<Movimentacao> implements MovimentacaoDAO{

	private Session session = DAOFactory.PegarSession();
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Movimentacao> listaFiltrada(Long id_movimentacao, Long id_caixa, Date dataInicialMovimentacao,
			Date dataFinalMovimentacao) {
		
		StringBuffer hql = new StringBuffer();

		hql.append("select m from Movimentacao m LEFT JOIN FETCH m.caixa c where 1=1 ");
		
		if(ManuseioPublico.validaObjeto(dataInicialMovimentacao)) {
			hql.append(" and m.dataInicialMovimentacao = "+dataInicialMovimentacao+"");
		}
		if(ManuseioPublico.validaObjeto(dataFinalMovimentacao)) {
			hql.append(" and m.dataFinalMovimentacao = "+dataFinalMovimentacao+"");
		}
		
		if (ManuseioPublico.validaObjeto(id_caixa)) {
			hql.append("and c.id_caixa = " + id_caixa + " ");
		}

		if (ManuseioPublico.validaObjeto(id_movimentacao)) {
			hql.append("and m.id_movimentacao = " + id_movimentacao + " ");
		}

		Query consulta = this.session.createQuery(hql.toString());
		List<Movimentacao> listaFiltrada = (List<Movimentacao>) consulta.list();
		
		return listaFiltrada;
		
		
		
	}

}
