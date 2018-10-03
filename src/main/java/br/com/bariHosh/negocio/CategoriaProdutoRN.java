package br.com.bariHosh.negocio;

import java.util.List;
import java.util.Objects;

import br.com.bariHosh.daoHibernate.CategoriaProdutoDAOHibernate;
import br.com.bariHosh.entidade.CategoriaProduto;

public class CategoriaProdutoRN {
	
	CategoriaProdutoDAOHibernate categoriaProdutoDao = new CategoriaProdutoDAOHibernate();

	public CategoriaProdutoRN() {
		
		this.categoriaProdutoDao = new CategoriaProdutoDAOHibernate();
	}
	
	
	public void salvar(CategoriaProduto categoria) {
		
		if(Objects.isNull(categoria.getId_categoria())) {
			
			this.categoriaProdutoDao.salvar(categoria);
			
		}else {
			
			this.categoriaProdutoDao.atualizar(categoria);
		}
		
	}
	
	public void excluir(CategoriaProduto categoria) {
		this.categoriaProdutoDao.excluir(categoria);
	}
	
	public CategoriaProduto carregar(CategoriaProduto categoira) {
		
		return this.categoriaProdutoDao.carregar(CategoriaProduto.class, categoira.getId_categoria());
		
	}
	public List<CategoriaProduto> listar(){
		
		return this.categoriaProdutoDao.listar(CategoriaProduto.class);
		
	}
	
	

}
