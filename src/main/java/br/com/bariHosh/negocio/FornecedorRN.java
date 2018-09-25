package br.com.bariHosh.negocio;

import java.util.List;

import br.com.bariHosh.daoHibernate.FornecedorDAOHibernate;
import br.com.bariHosh.daoHibernate.UsuarioDAOHibernate;
import br.com.bariHosh.entidade.Fornecedor;

public class FornecedorRN {

	private FornecedorDAOHibernate fornecedorDAO;

	public FornecedorRN() {
		this.fornecedorDAO = new FornecedorDAOHibernate();

	}

	public Fornecedor carregar(Long id) {
		return this.fornecedorDAO.carregar(Fornecedor.class, id);
	}

	public void salvar(Fornecedor fornecedor) {
		Long fornecedroID = fornecedor.getId_fornecedor();
		if (fornecedroID == null || fornecedroID == 0) {
			this.fornecedorDAO.salvar(fornecedor);
		} else {
			this.fornecedorDAO.atualizar(fornecedor);
		}
	}

	public void excluir(Fornecedor fornecedor) {
		Long forncedorID = fornecedor.getId_fornecedor();
		if (forncedorID == null || forncedorID == 0) {
			this.fornecedorDAO.excluir(fornecedor);
		}

	}

	public List<Fornecedor> listar() {
		return this.fornecedorDAO.listaFornecedores();
	}
}
