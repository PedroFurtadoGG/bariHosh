package br.com.bariHosh.negocio;

import java.util.List;

import br.com.bariHosh.daoHibernate.SangriaDAOHibernate;
import br.com.bariHosh.entidade.SangriaCaixa;
import br.com.bariHosh.util.ManuseioPublico;

public class SangriaRN extends ManuseioPublico {

	private SangriaDAOHibernate sangriaDAO;

	public SangriaRN() {
		this.sangriaDAO = new SangriaDAOHibernate();

	}

	public boolean salvar(SangriaCaixa sangria) {
		try {
			if (sangria.getCaixa().getValorTotal() >= sangria.getValorSangria()) {
				if (!super.validaObjeto(sangria.getId_sangria())) {
					this.sangriaDAO.salvar(sangria);
					super.MessagesSucesso("Sangria Realizada Com sucesso");
					return true;
				} else {
					this.sangriaDAO.atualizar(sangria);
					super.MessagesSucesso("Sangria Atualizada Com sucesso");
					return true;
				}

			}else {
				super.MessagesErro("Valor de Retirada Excede o valor limite do caixa");
				return false;
			}
		} catch (Exception e) {
			System.out.println("erro salvar atualizar" + e.getMessage());
			return false;
		}

	}

	public SangriaCaixa carregar(Long id) {
		try {
			return this.sangriaDAO.carregar(SangriaCaixa.class, id);

		} catch (Exception e) {
			System.out.println("erro carregar " + e.getMessage());
			return null;
		}

	}

	public boolean excluir(SangriaCaixa sangria) {

		try {
			if (super.validaObjeto(sangria.getId_sangria())) {
				this.sangriaDAO.excluir(sangria);
				super.MessagesSucesso("Sangria Excluido Com Sucesso!");
				return true;
			}

		} catch (Exception e) {
			System.out.println("erro excluir" + e.getMessage());
			super.MessagesErro("Ouve erro na tentativa de excluir o sangria contate Administrador do sistema!");
		}
		return false;

	}

	public List<SangriaCaixa> listar() {
		return this.sangriaDAO.listar(SangriaCaixa.class);
	}

}
