package br.com.bariHosh.negocio;

import java.util.List;
import java.util.Objects;

import br.com.bariHosh.daoHibernate.CategoriaProdutoDAOHibernate;
import br.com.bariHosh.entidade.CategoriaProduto;
import br.com.bariHosh.util.ManuseioPublico;

public class CategoriaProdutoRN extends ManuseioPublico{
	
	CategoriaProdutoDAOHibernate categoriaProdutoDao ;

	public CategoriaProdutoRN() {
		
		this.categoriaProdutoDao = new CategoriaProdutoDAOHibernate();
	}
	
	
	public boolean salvar(CategoriaProduto categoria) {
		try {
			if (!super.validaObjeto(categoria.getId_categoria())) {
				this.categoriaProdutoDao.salvar(categoria);				
				super.MessagesSucesso("Categoria Salvo Com Sucesso!");
	            return true;
			} else {
				this.categoriaProdutoDao.atualizar(categoria);	
				super.MessagesSucesso("Categoria Salvo Com Sucesso!");
	            return true;
			}
			
		} catch (Exception e) {
			System.out.println("erro salvar" + e.getMessage());
			super.MessagesErro(
					"Ouve erro na tentativa de salvar o categoria Verifique os campos Obrigatorios e tente novamente!");

		}
		return false;
	}

	public void excluir(CategoriaProduto categoria) {
		try {
			if (super.validaObjeto(categoria.getId_categoria())) {				
				this.categoriaProdutoDao.excluir(categoria);		
				super.MessagesSucesso("Categoria  Excluido Com Sucesso!");
			}

		} catch (Exception e) {
			System.out.println("erro excluir" + e.getMessage());
			super.MessagesErro("Ouve erro na tentativa de excluir a categoria de produto  contate Administrador do sistema!");
		}
		
		
	}
	
	public CategoriaProduto carregar(CategoriaProduto categoira) {
		
		return this.categoriaProdutoDao.carregar(CategoriaProduto.class, categoira.getId_categoria());
		
	}
	public List<CategoriaProduto> listar(){
		
		return this.categoriaProdutoDao.listar(CategoriaProduto.class);
		
	}
	
	

}