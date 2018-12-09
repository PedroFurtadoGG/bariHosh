package br.com.bariHosh.negocio;

import br.com.bariHosh.daoHibernate.CaixaDAOHibernate;
import br.com.bariHosh.entidade.Caixa;
import br.com.bariHosh.entidade.Usuario;
import br.com.bariHosh.util.ManuseioPublico;

public class CaixaRN extends ManuseioPublico {

	private CaixaDAOHibernate caixaDAO = new CaixaDAOHibernate();

	public CaixaRN() {

		this.caixaDAO = new CaixaDAOHibernate();
	}

	public boolean salvar(Caixa caixa) {
		Usuario usuarioLogado = super.buscarPorUsuarioLogado();
		if (super.validaObjeto(usuarioLogado.getId_usuario())) {
			caixa.setUsuarioCaixa(usuarioLogado);
			if (!super.validaObjeto(caixa.getId_caixa())) {
				new CaixaDAOHibernate().salvar(caixa);
				
				return true;
			} else {
				new CaixaDAOHibernate().atualizar(caixa);				
				return true;

			}
		} else {
			super.MessagesErro("E necessario Estar Logado!");

			return false;
		}

	}

	public boolean excluir(Caixa caixa) {

		if (!super.validaObjeto(caixa.getId_caixa())) {
			this.caixaDAO.excluir(caixa);
			return true;
		}
		return false;
	}

	public CaixaDAOHibernate getCaixaDAO() {
		return caixaDAO;
	}

	public void setCaixaDAO(CaixaDAOHibernate caixaDAO) {
		this.caixaDAO = caixaDAO;
	}

}
