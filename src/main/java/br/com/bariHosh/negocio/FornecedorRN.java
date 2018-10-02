package br.com.bariHosh.negocio;

import java.util.Date;
import java.util.List;

import br.com.bariHosh.daoHibernate.FornecedorDAOHibernate;
import br.com.bariHosh.entidade.Fornecedor;
import br.com.bariHosh.entidade.Usuario;
import br.com.bariHosh.util.ManuseioPublico;

public class FornecedorRN extends ManuseioPublico{

	private FornecedorDAOHibernate fornecedorDAO;

	public FornecedorRN() {
		this.fornecedorDAO = new FornecedorDAOHibernate();

	}

	public Fornecedor carregar(Long id) {
		return this.fornecedorDAO.carregar(Fornecedor.class, id);
	}

	public void salvar(Fornecedor fornecedor) {
		    Usuario usuariologado = super.buscarPorUsuarioLogado();
		if (super.validaObjeto(usuariologado.getId_usuario())) {
			
			   fornecedor.getPessoa().setId_usuario_criacao(usuariologado.getId_usuario());			
			if (!super.validaObjeto(fornecedor.getId_fornecedor())) {
				fornecedor.getPessoa().setDt_criacao(new Date());
				this.fornecedorDAO.salvar(fornecedor);
			} else {			
				fornecedor.getPessoa().setDt_alteracao(new Date());
				this.fornecedorDAO.atualizar(fornecedor);
			}
		}
	}

	public void excluir(Fornecedor fornecedor) {		
		if (super.validaObjeto(fornecedor.getId_fornecedor())) {
			this.fornecedorDAO.excluir(fornecedor);
		}
		
		

	}

	public List<Fornecedor> listar() {
		return this.fornecedorDAO.listaFornecedores();
	}
}
