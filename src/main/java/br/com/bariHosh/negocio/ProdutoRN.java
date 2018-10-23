package br.com.bariHosh.negocio;


import java.util.List;

import br.com.bariHosh.daoHibernate.ProdutoDAOHibernate;
import br.com.bariHosh.entidade.Produto;
import br.com.bariHosh.util.ManuseioPublico;

public class ProdutoRN  extends ManuseioPublico {
	
	private ProdutoDAOHibernate produtoDAO;

	public ProdutoRN() {
		this.produtoDAO = new ProdutoDAOHibernate();
		
		
	}
	public boolean salvar(Produto produto) {
		return false;
		
	}
	
	
	public Produto carregar(Long id) {
		return produtoDAO.carregar(Produto.class, id);
	}

	public List<Produto> listar() {		
	 return produtoDAO.listar(Produto.class);
	}


}
