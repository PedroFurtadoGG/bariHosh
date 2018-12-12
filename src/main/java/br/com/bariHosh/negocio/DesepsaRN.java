package br.com.bariHosh.negocio;

import br.com.bariHosh.daoHibernate.DespesaDAOHibernate;
import br.com.bariHosh.util.ManuseioPublico;

public class DesepsaRN extends ManuseioPublico{
	
	
	private DespesaDAOHibernate despesaDAO = new DespesaDAOHibernate();

	public DespesaDAOHibernate getDespesaDAO() {
		return despesaDAO;
	}

	public void setDespesaDAO(DespesaDAOHibernate despesaDAO) {
		this.despesaDAO = despesaDAO;
	}
	
	

}
