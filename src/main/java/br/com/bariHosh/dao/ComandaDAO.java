package br.com.bariHosh.dao;

import java.util.Date;
import java.util.List;

import br.com.bariHosh.entidade.*;

public interface ComandaDAO {
	
	public Comanda pegarPeloItem(ItemComanda iten);
	public List<Comanda> listaPedidosCancelados();
	public List<Comanda> listaPedidosFinalizados();
	public List<Comanda> listaPedidosCliente(Cliente cliente);
	public List<Comanda> listaPedidosNaDataAtual(Date data);	
	public List<Comanda> listaComandasStatus(boolean status);
	

}
