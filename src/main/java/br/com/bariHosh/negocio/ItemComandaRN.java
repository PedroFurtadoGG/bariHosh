package br.com.bariHosh.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.bariHosh.daoHibernate.ItemComandaDAOHibernate;
import br.com.bariHosh.entidade.ItemComanda;
import br.com.bariHosh.util.ManuseioPublico;

public class ItemComandaRN  extends ManuseioPublico{

	
	private ItemComandaDAOHibernate itemComandaDAO = new ItemComandaDAOHibernate();
	   
	public List<ItemComanda> listaIntemComandaPorComandaId(Long id_comanda) {
		  List<ItemComanda> lista = new ArrayList<ItemComanda>();
		if(id_comanda!=null) {
			 lista = itemComandaDAO.listaItensPorComandaId(id_comanda);
		}
		  
		  return lista;
	
	}

	public boolean excluir(ItemComanda model ) {
		try {
			itemComandaDAO.excluir(model);
			super.MessagesSucesso("Item Removido Com Sucesso ");
			return true ;
			
		}catch (Exception e) {
			System.out.println("erro excluir" + e.getMessage());
			super.MessagesErro("Ouve erro na tentativa de excluir o item contate Administrador do sistema!");
		}
		
		return false;
	}
	
	public List<ItemComanda> listaItems(){		
		return itemComandaDAO.listar(ItemComanda.class);
	}
	
}
