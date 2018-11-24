package br.com.bariHosh.negocio;

import java.util.List;

import javax.faces.context.FacesContext;

import br.com.bariHosh.daoHibernate.ComandaDAOHibernate;
import br.com.bariHosh.daoHibernate.PagamentoDAOHibernate;
import br.com.bariHosh.entidade.Comanda;
import br.com.bariHosh.entidade.EnumStatusPagamento;
import br.com.bariHosh.entidade.Pagamento;
import br.com.bariHosh.entidade.Usuario;
import br.com.bariHosh.ordenadores.OrdenadorComanda;
import br.com.bariHosh.util.ManuseioPublico;

public class ComandaRN extends ManuseioPublico {

	private ComandaDAOHibernate comandaDAO = new ComandaDAOHibernate();
    private PagamentoDAOHibernate pagamentoDAO = new PagamentoDAOHibernate();
    
    
	public boolean salvar(Comanda comanda) {
		try {
			Usuario usuarioLogado = super.buscarPorUsuarioLogado();
			if (super.validaObjeto(usuarioLogado.getId_usuario())) {
				// injetando id usuario
				comanda.setUsuario(usuarioLogado);
				if (!super.validaObjeto(comanda.getId_comanda())) {
					this.comandaDAO.salvar(comanda);
					super.MessagesSucesso("Comanda Salva Com Sucesso ");
					return true;
				} else {
					super.MessagesSucesso("Comanda Atualizada  Com Sucesso ");
					this.comandaDAO.atualizar(comanda);
					return true;
				}
			} else {
				super.MessagesErro("E necessario Estar Logado!");

				return false;
			}
		} catch (Exception e) {
			super.MessagesErro("Ouve erro na tentativa de salvar a comanda contate Administrador do sistema!");
		}
		return false;

	}
	
	public boolean finalizar(Comanda comanda) {
		try {
			Usuario usuarioLogado = super.buscarPorUsuarioLogado();
			if (super.validaObjeto(usuarioLogado.getId_usuario())) {
				// injetando id usuario
				   comanda.setUsuario(usuarioLogado);	
				   
					Pagamento pagamento = new Pagamento();
					pagamento.setStatusPagamento(EnumStatusPagamento.EM_ABERTO);
					pagamento.setCompletamenteRecebido(false);
//					pagamento.se
					this.comandaDAO.atualizar(comanda);
					super.MessagesSucesso("Comanda Finalizada  Com Sucesso ");
					return true;
				
			} else {
				super.MessagesErro("E necessario Estar Logado!");

				return false;
			}
		} catch (Exception e) {
			super.MessagesErro("Ouve erro na tentativa de salvar a comanda contate Administrador do sistema!");
		}
		return false;

	}


	public boolean excluir(Comanda comanda) {
		try {
			if (super.validaObjeto(comanda.getId_comanda())) {
				this.comandaDAO.excluir(comanda);
				super.MessagesSucesso("Comanda Excluido Com Sucesso!");
				return true;
			}
		} catch (Exception e) {
			super.MessagesErro("Ouve erro na tentativa de excluir a comanda contate Administrador do sistema!");
			return false;
		}
		return false;
	}

	public ComandaDAOHibernate getComandaDAO() {
		return comandaDAO;
	}

	public void setComandaDAO(ComandaDAOHibernate comandaDAO) {
		this.comandaDAO = comandaDAO;
	}




	public List<Comanda> listaComandasStatus(boolean status) {
		OrdenadorComanda listaOrdenada = new OrdenadorComanda(this.comandaDAO.listaComandasStatus(status));
		return listaOrdenada.listagemEmOrdem();
	}

	public Comanda recuperaComandaParaEdicao() {
		String idcomanda = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
				.get("id_comanda");
		if (super.validaObjeto(idcomanda)) {
			return this.comandaDAO.carregar(Comanda.class, Long.parseLong(idcomanda));
		}
		return null;
	}

	

}
