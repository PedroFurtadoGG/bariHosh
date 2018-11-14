package br.com.bariHosh.dao;

import java.util.List;

import br.com.bariHosh.entidade.*;


public interface ItemComandaDAO {
	
	
	public ItemComanda pegaItemPeloPedido(Comanda comanda);
	public List<ItemComanda> listaItemsDevolvidos();
	public List<ItemComanda> listaItensPorComandaId(Long id_comanda);
	

}
