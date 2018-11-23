package br.com.bariHosh.negocio;

import java.util.List;

import br.com.bariHosh.daoHibernate.ComandaDAOHibernate;
import br.com.bariHosh.entidade.Comanda;
import br.com.bariHosh.util.ManuseioPublico;

public class ComandaRN extends ManuseioPublico {

	private ComandaDAOHibernate comandaDAO = new ComandaDAOHibernate();

	public boolean salvar(Comanda comanda) {

		if (!super.validaObjeto(comanda.getId_comanda())) {
			this.comandaDAO.salvar(comanda);
			return true;
		} else {
			this.comandaDAO.atualizar(comanda);
			return true;

		}

	}

	public boolean excluir(Comanda comanda) {

		if (!super.validaObjeto(comanda.getId_comanda())) {
			this.comandaDAO.excluir(comanda);
			return true;
		}
		return false;
	}

	public ComandaDAOHibernate getComandaDAO() {
		return comandaDAO;
	}

	public void setComandaDAO(ComandaDAOHibernate comandaDAO) {
		this.comandaDAO = comandaDAO;
	}

	public List<Comanda> listaComandasStatus(boolean status) {

		return this.comandaDAO.listaComandasStatus(status);
	}

}
