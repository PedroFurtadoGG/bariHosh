package br.com.bariHosh.daoHibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.bariHosh.dao.LogEstoqueDAO;
import br.com.bariHosh.entidade.Log_Estoque;
import br.com.bariHosh.util.DAOFactory;

public class LogEstoqueDAOHibernate extends GenericoDAOHibernate<Log_Estoque>  
      implements LogEstoqueDAO{
    	  
    	  private Session session  = DAOFactory.PegarSession();

		@Override
		public List<Log_Estoque> ListaEtoqueVinculados(Long id_estoque) {
			String hql = "select l from Log_Estoque l where l.estoque = :idestoque";
			Query consulta = this.session.createQuery(hql);
			consulta.setLong("idestoque", id_estoque);
			List<Log_Estoque> listaEstoque = new ArrayList<Log_Estoque>();
			   listaEstoque = consulta.list();
			return listaEstoque ;
		}

		

}
