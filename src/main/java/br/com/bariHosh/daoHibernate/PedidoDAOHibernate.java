package br.com.bariHosh.daoHibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import br.com.bariHosh.dao.PedidoDAO;
import br.com.bariHosh.entidade.*;
import br.com.bariHosh.util.DAOFactory;

public class PedidoDAOHibernate extends GenericoDAOHibernate<Pedido> implements PedidoDAO {

	private Session session = DAOFactory.PegarSession();

	@Override
	public Pedido pegarPeloItem(ItemDoPedido iten) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> listaPedidosCancelados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> listaPedidosFinalizados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> listaPedidosCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> listaPedidosNaDataAtual(Date data) {
		// TODO Auto-generated method stub
		return null;
	}

}
