package br.com.bariHosh.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.bariHosh.daoHibernate.ItemComandaDAOHibernate;
import br.com.bariHosh.entidade.ItemComanda;
import br.com.bariHosh.util.ManuseioPublico;

public class ItemComandaRN  extends ManuseioPublico{

	
	private ItemComandaDAOHibernate itemComandaDAO = new ItemComandaDAOHibernate();
	
	public List<ItemComanda> listaIntemComandaPorComandaId(Long id_comanda) {
		  List<ItemComanda> list = itemComandaDAO.listaItensPorComandaId(id_comanda);
		  if(list ==null) {		  
			  list  = new ArrayList<ItemComanda>();
		  }	    
	
	return list;
	}

	public boolean excluir(ItemComanda model ) {
		itemComandaDAO.excluir(model);
		return false;
	}
	
}
