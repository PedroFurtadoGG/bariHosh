package br.com.bariHosh.negocio;

import java.util.List;

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
				super.MessagesSucesso("Categoria Atualizado Com Sucesso!");
	            return true;
			}
			
		} catch (Exception e) {
			System.out.println("erro salvar" + e.getMessage());
			super.MessagesErro(
					"Ouve erro na tentativa de salvar o categoria Verifique os campos Obrigatorios e tente novamente!");

		}
		return false;
	}

	public boolean excluir(CategoriaProduto categoria) {		

		try {
			if (super.validaObjeto(categoria.getId_categoria())) {			
				if (categoriaProdutoDao.ListaProdutosVinculados(categoria.getId_categoria()).size() == 0) {
					this.categoriaProdutoDao.excluir(categoria);
					super.MessagesSucesso("Categoria  Excluido Com Sucesso!");
					return true;
				} else {
					super.MessagesErro(
							"Existe Produtos vinculados a Esta Categoria ! Por favor atualize os dados de Produto !");
					return false;
				}
			}

		} catch (Exception e) {
			System.out.println("erro excluir" + e.getMessage());
			super.MessagesErro(
					"Ouve erro na tentativa de excluir a categoria de produto  contate Administrador do sistema!");
		}
		return false;

	}
	
	public CategoriaProduto carregar(CategoriaProduto categoria) {
		
		return this.categoriaProdutoDao.carregar(CategoriaProduto.class, categoria.getId_categoria());
		
	}
	public List<CategoriaProduto> listar(){
		
		return this.categoriaProdutoDao.listar(CategoriaProduto.class);
		
	}


	public List<CategoriaProduto> listaFiltrada(String descricao, Long id_categoria) {
		return categoriaProdutoDao.listaFiltrada(descricao, id_categoria);
	}
	
	
	
	

}
