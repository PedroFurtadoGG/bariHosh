package br.com.bariHosh.daoHibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.bariHosh.dao.FabricanteDAO;
import br.com.bariHosh.entidade.Fabricante;
import br.com.bariHosh.util.DAOFactory;
import br.com.bariHosh.util.ManuseioPublico;

public class FabricanteDAOHibernate extends GenericoDAOHibernate<Fabricante> implements FabricanteDAO{

		private Session session = DAOFactory.PegarSession();

		@SuppressWarnings("unchecked")
		@Override
		public List<Fabricante> listaFiltrada(Long id_fabricante, String razaoSocial) {
		
			StringBuffer hql = new StringBuffer();
			hql.append("select f from Fabricante f where f.razaoSocial like '%"+ razaoSocial +"%' ");
			if(ManuseioPublico.validaObjeto(id_fabricante)) {
				hql.append("and f.id_fabricante ='" +id_fabricante+"'");
			}
			
			Query consulta = this.session.createQuery(hql.toString());
			List<Fabricante> listaFiltrada = (List<Fabricante>) consulta.list();

			return listaFiltrada;
		}
		
		
}
