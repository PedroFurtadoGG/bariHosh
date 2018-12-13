package br.com.bariHosh.negocio;

import java.util.List;

import br.com.bariHosh.daoHibernate.CaixaDAOHibernate;
import br.com.bariHosh.daoHibernate.ClienteDAOHibernate;
import br.com.bariHosh.daoHibernate.ComandaDAOHibernate;
import br.com.bariHosh.daoHibernate.ProdutoDAOHibernate;
import br.com.bariHosh.entidade.Caixa;
import br.com.bariHosh.entidade.Comanda;
import br.com.bariHosh.entidade.Produto;
import br.com.bariHosh.util.ManuseioPublico;

public class DashboardRN extends ManuseioPublico{
	
	private ClienteDAOHibernate clienteDAO;
	private ComandaDAOHibernate comandaDAO;
	private ProdutoDAOHibernate produtoDAO;
	private CaixaDAOHibernate caixaDAO;
	
	public DashboardRN() {
		this.clienteDAO = new ClienteDAOHibernate();
		this.comandaDAO = new ComandaDAOHibernate();
		this.produtoDAO = new ProdutoDAOHibernate();
		this.caixaDAO = new CaixaDAOHibernate();
	}
	public String totalClientesRegistrados() {
		
		return this.clienteDAO.totalClientesRegistrados();
		
	}
	
	public List<Produto> listarProximosVencimentos(){
		
		return this.produtoDAO.listarProximosVencimentos();
	}
	
	
	public List<Caixa> listarUltimasMovimentacoes(String tipoMovimentacao){
		return this.caixaDAO.listarMovimentacoes(tipoMovimentacao);
	}
	
	public List<Comanda> listarComandasAbertas(boolean status){
		return this.comandaDAO.listaComandasStatus(status, null);
	}

}
