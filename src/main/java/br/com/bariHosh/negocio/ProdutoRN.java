package br.com.bariHosh.negocio;

import java.util.List;

import br.com.bariHosh.daoHibernate.ProdutoDAOHibernate;
import br.com.bariHosh.entidade.Produto;
import br.com.bariHosh.util.ManuseioPublico;

public class ProdutoRN extends ManuseioPublico {

	private ProdutoDAOHibernate produtoDAO;

	public ProdutoRN() {
		this.produtoDAO = new ProdutoDAOHibernate();
	}

	public Produto carregar(Long id) {
		return this.produtoDAO.carregar(Produto.class, id);
	}

	public boolean salvar(Produto produto) {
		try {

			if (!super.validaObjeto(produto.getId_produto())) {
				this.produtoDAO.salvar(produto);
				super.MessagesSucesso("Produto salvo com sucesso !");
				return true;
			} else {
				this.produtoDAO.atualizar(produto);
				super.MessagesSucesso("Produto atualizado com sucesso !");
				return true;
			}

		} catch (Exception e) {
			System.out.println("erro ao salvar :" + e.getMessage());
			super.MessagesErro(
					"Ocorreu um erro na tentativa de salvar o Produto, verifique os campos obrigatrio e tente novamente.");
		}
		return false;
	}

	public void excluir(Produto produto) {
		try {

			if (super.validaObjeto(produto.getId_produto())) {
				this.produtoDAO.excluir(produto);
				super.MessagesSucesso("Produto deletado com sucesso !");
			}

		} catch (Exception e) {
			System.out.println("erro ao excluir :" + e.getMessage());
			super.MessagesErro("Ocorreu um erro ao tentar excluir o Produto.");
		}
	}

	public List<Produto> listar() {
		return this.produtoDAO.listar(Produto.class);
	}

}
