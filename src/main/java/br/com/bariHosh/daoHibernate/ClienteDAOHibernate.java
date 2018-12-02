package br.com.bariHosh.daoHibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.bariHosh.dao.ClienteDAO;
import br.com.bariHosh.entidade.Cliente;
import br.com.bariHosh.util.DAOFactory;
import br.com.bariHosh.util.ManuseioPublico;

public class ClienteDAOHibernate extends GenericoDAOHibernate<Cliente> implements ClienteDAO {

	private Session session = DAOFactory.PegarSession();

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> listaFiltrada(String nome, String cpf, Long id_cliente) {
		StringBuffer hql = new StringBuffer();

		hql.append("select c from Cliente c LEFT JOIN FETCH c.pessoa p  ");
		hql.append(" where p.nome like '%" + nome + "%' ");

		if (!cpf.equals("")) {
			hql.append("and p.cpf = '" + cpf + "' ");
		}

		if (!ManuseioPublico.validaObjeto(id_cliente)) {
			hql.append("and c.id_cliente = " + id_cliente + " ");
		}

		Query consulta = this.session.createQuery(hql.toString());
		List<Cliente> listaFiltrada = (List<Cliente>) consulta.list();
		
		return listaFiltrada;
	}

}
