package br.com.bariHosh.negocio;

import java.util.List;

import br.com.bariHosh.daoHibernate.GenericoDAOHibernate;
import br.com.bariHosh.daoHibernate.MarcaDAOHibernate;
import br.com.bariHosh.entidade.Marca;

public class MarcaRN {
	
	private GenericoDAOHibernate<Marca> dao;
	private MarcaDAOHibernate marcaDAO;
	
	public MarcaRN() {
		this.dao = new GenericoDAOHibernate<Marca>();
		this.marcaDAO = new MarcaDAOHibernate();
	}
	
	public Marca carregar(Long id) {
		return this.dao.carregar(id);
	}
	
	public void  salvar(Marca marca) {
		
		Long marcaId = marca.getId_marca();
		if(marcaId == null || marcaId ==0) {
			this.dao.salvar(marca);
		}else {
			this.dao.atualizar(marca);
		}
		
	}
	
	public void  excluir(Marca marca) {
		this.marcaDAO.excluir(marca);
	}
	
	public List<Marca> listar(){
		return this.marcaDAO.listar();
	}

}
