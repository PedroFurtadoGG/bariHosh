package br.com.bariHosh.daoHibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.bariHosh.dao.ComandaDAO;
import br.com.bariHosh.entidade.Cliente;
import br.com.bariHosh.entidade.Comanda;
import br.com.bariHosh.entidade.ItemComanda;
import br.com.bariHosh.util.DAOFactory;
import br.com.bariHosh.util.ManuseioPublico;

public class ComandaDAOHibernate extends GenericoDAOHibernate<Comanda> implements ComandaDAO {

	private Session session = DAOFactory.PegarSession();

	@Override
	public Comanda pegarPeloItem(ItemComanda iten) {

		return null;
	}

	@Override
	public List<Comanda> listaPedidosCancelados() {

		return null;
	}

	@Override
	public List<Comanda> listaPedidosFinalizados() {

		return null;
	}

	@Override
	public List<Comanda> listaPedidosCliente(Cliente cliente) {

		return null;
	}

	@Override
	public List<Comanda> listaPedidosNaDataAtual(Date data) {

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
	public List<Comanda> listaComandasStatus(boolean status , Enum e) {
		String hql = "select c from Comanda c JOIN FETCH c.cliente o  where c.ativo = :status and c.statusComanda = :enumstatus";
			 					
		Query consulta = this.session.createQuery(hql);
		consulta.setBoolean("status", status);
		consulta.setParameter("enumstatus", e);	
		List<Comanda> list = (List<Comanda>) consulta.list();
		return list;

	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Comanda> listaFiltrada(Long id_comanda, String nome) {
		StringBuffer hql = new StringBuffer();

		hql.append("select c from Comanda c LEFT JOIN FETCH c.pessoa p  ");
		hql.append(" where p.nome like '%" + nome + "%' ");

		if (!ManuseioPublico.validaObjeto(id_comanda)) {
			hql.append("and c.id_comanda = " + id_comanda + " ");
		}

		Query consulta = this.session.createQuery(hql.toString());
		List<Comanda> listaFiltrada = (List<Comanda>) consulta.list();

		return listaFiltrada;
	}


}
