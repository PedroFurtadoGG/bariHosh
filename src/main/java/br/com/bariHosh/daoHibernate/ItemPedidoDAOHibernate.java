package br.com.bariHosh.daoHibernate;

import java.util.List;

import org.hibernate.Session;

import br.com.bariHosh.dao.ItemPedidoDAO;
import br.com.bariHosh.entidade.*;
import br.com.bariHosh.util.DAOFactory;

public class ItemPedidoDAOHibernate extends GenericoDAOHibernate<ItemDoPedido> implements ItemPedidoDAO {

	private Session session = DAOFactory.PegarSession();

	@Override
	public ItemDoPedido pegaItemPeloPedido(Pedido pedido) {
		
		return null;
	}

	@Override
	public List<ItemDoPedido> listaItemsDevolvidos() {
		
		return null;
	}

}
