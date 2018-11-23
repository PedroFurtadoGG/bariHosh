package br.com.bariHosh.daoHibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.bariHosh.dao.ItemComandaDAO;
import br.com.bariHosh.entidade.*;
import br.com.bariHosh.util.DAOFactory;

public class ItemComandaDAOHibernate extends GenericoDAOHibernate<ItemComanda> implements ItemComandaDAO {

	private Session session = DAOFactory.PegarSession();

	@Override
	public ItemComanda pegaItemPeloPedido(Comanda comanda) {
		
		return null;
	}

	@Override
	public List<ItemComanda> listaItemsDevolvidos() {
		
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
	public List<ItemComanda> listaItensPorComandaId(Long id_comanda) {
		
		String hql = " from ItemComanda i JOIN FETCH i.comanda c JOIN FETCH i.produto p where i.comanda = :idcomanda ";
		
		Query consulta = this.session.createQuery(hql);
		      consulta.setLong("idcomanda", id_comanda);
		List<ItemComanda> list = (List<ItemComanda> ) consulta.list();		
		return list;
	}

	
	
	
	
}
