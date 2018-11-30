package br.com.bariHosh.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.bariHosh.daoHibernate.ItemComandaDAOHibernate;
import br.com.bariHosh.entidade.ItemComanda;
import br.com.bariHosh.util.ManuseioPublico;

public class ItemComandaRN extends ManuseioPublico {

	private ItemComandaDAOHibernate itemComandaDAO = new ItemComandaDAOHibernate();

	public List<ItemComanda> listaIntemComandaPorComandaId(Long id_comanda) {
		List<ItemComanda> lista = new ArrayList<ItemComanda>();
		if (id_comanda != null) {
			lista = itemComandaDAO.listaItensPorComandaId(id_comanda);
		}

		return lista;

	}

	public boolean excluirItemComanda(ItemComanda model) {
		try {
			itemComandaDAO.excluir(model);
			super.MessagesSucesso("Item Removido Com Sucesso ");
			return true;

		} catch (Exception e) {
			System.out.println("erro excluir" + e.getMessage());
			super.MessagesErro("Ouve erro na tentativa de excluir o item contate Administrador do sistema!");
		}

		return false;
	}

	public List<ItemComanda> listaItems() {
		return itemComandaDAO.listar(ItemComanda.class);
	}

	public boolean ValidaEstoque(ItemComanda itemComanda) {

		if (itemComanda.getQuantidade() >= 1) {
			if (itemComanda.getProduto().getEstoque().getQtd_produto() >= itemComanda.getQuantidade()) {
				
				return true;
			}
			super.MessagesErro("Quantidade maior que quantia armazenado em estoque");
		} else {
			super.MessagesErro("Quantidade tem que ser maior que 0 !");

		}

		return false;
	}

}
