package br.com.bariHosh.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.bariHosh.daoHibernate.MovimentacaoDAOHibernate;
import br.com.bariHosh.entidade.Movimentacao;
import br.com.bariHosh.util.ManuseioPublico;

public class MovimentacaoRN extends ManuseioPublico{
	
	private MovimentacaoDAOHibernate movimentacaoDAO = new MovimentacaoDAOHibernate();
	

	public MovimentacaoDAOHibernate getMovimentacaoDAO() {
		return movimentacaoDAO;
	}

	public void setMovimentacaoDAO(MovimentacaoDAOHibernate movimentacaoDAO) {
		this.movimentacaoDAO = movimentacaoDAO;
	}

	public List<Movimentacao> listaDeMovimentacoes() {
		List<Movimentacao> listamov = new ArrayList<Movimentacao>();
		try {
			listamov =this.movimentacaoDAO.listar(Movimentacao.class);
			
		}catch (Exception e) {
		System.out.println("erro consulta"+e.getMessage());
		}
		return listamov;
	}
	

}
