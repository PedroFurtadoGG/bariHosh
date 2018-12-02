package br.com.bariHosh.negocio;

import br.com.bariHosh.daoHibernate.MovimentacaoDAOHibernate;
import br.com.bariHosh.util.ManuseioPublico;

public class MovimentacaoRN extends ManuseioPublico{
	
	private MovimentacaoDAOHibernate movimentacaoDAO = new MovimentacaoDAOHibernate();
	

	public MovimentacaoDAOHibernate getMovimentacaoDAO() {
		return movimentacaoDAO;
	}

	public void setMovimentacaoDAO(MovimentacaoDAOHibernate movimentacaoDAO) {
		this.movimentacaoDAO = movimentacaoDAO;
	}
	

}
