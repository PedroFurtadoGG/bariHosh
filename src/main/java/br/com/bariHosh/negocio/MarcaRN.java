package br.com.bariHosh.negocio;

import java.util.List;
import java.util.Objects;

import br.com.bariHosh.daoHibernate.FabricanteDAOHibernate;
import br.com.bariHosh.daoHibernate.MarcaDAOHibernate;
import br.com.bariHosh.entidade.Fabricante;
import br.com.bariHosh.entidade.Marca;

public class MarcaRN {
	
//	private GenericoDAOHibernate<Marca> dao;
	private MarcaDAOHibernate marcaDAO;
	private FabricanteDAOHibernate fabricanteDAO;
	
	public MarcaRN() {
//		this.dao = new GenericoDAOHibernate<Marca>();
		this.marcaDAO = new MarcaDAOHibernate();
		this.fabricanteDAO = new FabricanteDAOHibernate();
	}
	
	public Marca carregar(Long id) {
		return this.marcaDAO.carregar(Marca.class,id);
	}
	
	public void  salvar(Marca marca) {
		
		if(Objects.isNull(marca.getId_marca())) {
			
			Fabricante fab = marca.getFabricante();
			this.fabricanteDAO.salvar(fab);
			marca.setFabricante(fab);
			this.marcaDAO.salvar(marca);
			
		}else {
			
			this.fabricanteDAO.atualizar(marca.getFabricante());
			this.marcaDAO.atualizar(marca);
		}
		
	}
	
	public void  excluir(Marca marca) {
		this.marcaDAO.excluir(marca);
	}
	
	public List<Marca> listar(){
		return this.marcaDAO.listar(Marca.class);
	}

}
