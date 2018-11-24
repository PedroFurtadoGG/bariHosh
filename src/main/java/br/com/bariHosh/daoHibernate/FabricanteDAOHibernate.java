package br.com.bariHosh.daoHibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.bariHosh.dao.FabricanteDAO;
import br.com.bariHosh.entidade.Fabricante;
import br.com.bariHosh.util.DAOFactory;

public class FabricanteDAOHibernate extends GenericoDAOHibernate<Fabricante> implements FabricanteDAO{

		private Session session = DAOFactory.PegarSession();

		@SuppressWarnings("unchecked")
		@Override
		public List<Fabricante> listaFiltrada(String cnpj, String razaoSocial) {
		
			StringBuffer hql = new StringBuffer();
			hql.append("select f from Fabricante f where f.razaoSocial like '%"+ razaoSocial +"%' ");
			if(!cnpj.equals("")) {
				hql.append("and f.cnpj ='" +cnpj+"'");
			}
			
			Query consulta = this.session.createQuery(hql.toString());
			List<Fabricante> listaFiltrada = (List<Fabricante>) consulta.list();

			return listaFiltrada;
		}
		
		
}
