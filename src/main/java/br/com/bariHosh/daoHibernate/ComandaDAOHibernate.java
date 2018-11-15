package br.com.bariHosh.daoHibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.bariHosh.dao.ComandaDAO;
import br.com.bariHosh.entidade.*;
import br.com.bariHosh.util.DAOFactory;

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
	@Override
	public List<Comanda> listaComandasStatus(boolean status) {
		String hql = "select c from Comanda c  "
				+ " JOIN FETCH c.cliente e   where c.ativo = :status ";
			 					
		Query consulta = this.session.createQuery(hql);
		      consulta.setBoolean("status", status);
		List<Comanda> list = (List<Comanda> ) consulta.list();
		
		return list;		
		
	}
	
	

}
