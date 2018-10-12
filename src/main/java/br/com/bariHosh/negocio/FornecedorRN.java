package br.com.bariHosh.negocio;

import java.util.Date;
import java.util.List;
import br.com.bariHosh.daoHibernate.FornecedorDAOHibernate;
import br.com.bariHosh.entidade.Fornecedor;
import br.com.bariHosh.entidade.Usuario;
import br.com.bariHosh.util.ManuseioPublico;

public class FornecedorRN extends ManuseioPublico {

	private FornecedorDAOHibernate fornecedorDAO;

	public FornecedorRN() {
		this.fornecedorDAO = new FornecedorDAOHibernate();

	}

	public Fornecedor carregar(Long id) {
		return this.fornecedorDAO.carregar(Fornecedor.class, id);
	}

	public boolean salvar(Fornecedor fornecedor) {
		try {
			if (super.isCPF(fornecedor.getPessoa().getCpf())) {
				if (super.CalcularIdade(fornecedor.getPessoa().getDt_nascimento())) {
					Usuario usuarioLogado = super.buscarPorUsuarioLogado();
					if (super.validaObjeto(usuarioLogado.getId_usuario())) {
						fornecedor.getPessoa().setId_usuario_criacao(usuarioLogado.getId_usuario());
						if (!super.validaObjeto(fornecedor.getId_fornecedor())) {
							fornecedor.getPessoa().setDt_criacao(new Date());
							this.fornecedorDAO.salvar(fornecedor);
						} else {
							fornecedor.getPessoa().setDt_alteracao(new Date());
							this.fornecedorDAO.atualizar(fornecedor);
						}
						super.MessagesSucesso("Fornecedor Salvo Com Sucesso!");
						return true;

					} else {
						super.MessagesErro("E Necessario Estar Logado! ");

						return false;
					}

				} else {
					super.MessagesErro("A Idade e Inferior a 18 anos!");
					return false;
				}
			} else {
				super.MessagesErro("Cpf Invalido!");
				return false;
			}

		} catch (Exception e) {
			System.out.println("erro salvar" + e.getMessage());
			super.MessagesErro(
					"Ouve erro na tentativa de salvar o fornecedor Verifique os campos Obrigatorios e tente novamente!");

		}
		return false;

	}

	public void excluir(Fornecedor fornecedor) {
		try {
			if (super.validaObjeto(fornecedor.getId_fornecedor())) {
				this.fornecedorDAO.excluir(fornecedor);
				super.MessagesSucesso("Fornecedor Excluido Com Sucesso!");
			}

		} catch (Exception e) {
			System.out.println("erro excluir" + e.getMessage());
			super.MessagesErro("Ouve erro na tentativa de excluir o fornecedor contate Administrador do sistema!");
		}

	}

	public List<Fornecedor> listar() {
		return this.fornecedorDAO.listaFornecedores();

	}

}
