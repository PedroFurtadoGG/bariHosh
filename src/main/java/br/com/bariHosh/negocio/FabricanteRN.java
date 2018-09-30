package br.com.bariHosh.negocio;

import java.util.List;

import br.com.bariHosh.daoHibernate.FabricanteDAOHibernate;
import br.com.bariHosh.entidade.Fabricante;

public class FabricanteRN {
	

	private FabricanteDAOHibernate fabricanteDAO;
	
	public FabricanteRN(){
	
		this.fabricanteDAO = new FabricanteDAOHibernate();
	}
	
	public void salvar(Fabricante fab) {
		
		Long fabId = fab.getId_fabricante();
		if(fabId == null || fabId==0) {
			this.fabricanteDAO.salvar(fab);
		}else {
			this.fabricanteDAO.atualizar(fab);
		}
		
	}
	
	public Fabricante carregar(Long id) {
		return this.fabricanteDAO.carregar(Fabricante.class,id);
	}
	
	public void excluir(Fabricante fab) {
		this.fabricanteDAO.excluir(fab);
	}
	
	public List<Fabricante> listar(){
		return this.fabricanteDAO.listar(Fabricante.class);
	}

}
