package br.com.bariHosh.dao;

import java.util.Date;
import java.util.List;

import br.com.bariHosh.entidade.*;

public interface PedidoDAO {
	
	public Pedido pegarPeloItem(ItemDoPedido iten);
	public List<Pedido> listaPedidosCancelados();
	public List<Pedido> listaPedidosFinalizados();
	public List<Pedido> listaPedidosCliente(Cliente cliente);
	public List<Pedido> listaPedidosNaDataAtual(Date data);

}
