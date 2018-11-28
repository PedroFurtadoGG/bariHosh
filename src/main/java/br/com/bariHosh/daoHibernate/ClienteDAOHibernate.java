package br.com.bariHosh.daoHibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.bariHosh.dao.ClienteDAO;
import br.com.bariHosh.entidade.Cliente;
import br.com.bariHosh.util.DAOFactory;

public class ClienteDAOHibernate extends GenericoDAOHibernate<Cliente> implements ClienteDAO {
	
	private Session session = DAOFactory.PegarSession();
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> listaFiltrada(String nome, String cpf) {
		StringBuffer hql = new StringBuffer();
		
		hql.append("select c from Cliente c LEFT JOIN FETCH c.pessoa p  ");
		hql.append(" where p.nome like '%"+ nome +"%' ");
		
		if(!cpf.equals("")) {
			hql.append("and p.cpf = '" + cpf +"' ");
		}
		
		Query consulta = this.session.createQuery(hql.toString());
		List<Cliente> listaFiltrada = (List<Cliente>) consulta.list();
		
		return listaFiltrada;
	}

	@Override
	public String totalClientesRegistrados() {
	
		String sql = "SELECT count(c.id) FROM Cliente c WHERE c.id";
		
		Query consulta = this.session.createQuery(sql);
		String resultado = consulta.getMaxResults().toString();
		
		return resultado;
	}


}
