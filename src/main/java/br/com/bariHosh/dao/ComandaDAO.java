package br.com.bariHosh.dao;

import java.util.Date;
import java.util.List;

import br.com.bariHosh.entidade.Cliente;
import br.com.bariHosh.entidade.Comanda;
import br.com.bariHosh.entidade.ItemComanda;

public interface ComandaDAO {
	
	public Comanda pegarPeloItem(ItemComanda iten);
	public List<Comanda> listaPedidosCancelados();
	public List<Comanda> listaPedidosFinalizados();
	public List<Comanda> listaPedidosCliente(Cliente cliente);
	public List<Comanda> listaPedidosNaDataAtual(Date data);	
	public  List<Comanda> listaComandasStatus(boolean status, Enum e);
	List<Comanda> listaFiltrada(Long id_comanda, String nome);
	List<Comanda> listaFiltradaFechada(Long id_comanda, String nome);
	

}
