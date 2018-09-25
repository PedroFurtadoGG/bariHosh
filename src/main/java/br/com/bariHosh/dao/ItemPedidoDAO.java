package br.com.bariHosh.dao;

import java.util.List;

import br.com.bariHosh.entidade.*;


public interface ItemPedidoDAO {
	
	
	public ItemDoPedido pegaItemPeloPedido(Pedido pedido);
	public List<ItemDoPedido> listaItemsDevolvidos();

}
