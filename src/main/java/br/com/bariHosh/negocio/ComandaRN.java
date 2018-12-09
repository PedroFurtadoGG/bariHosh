package br.com.bariHosh.negocio;

import java.util.List;

import javax.faces.context.FacesContext;

import br.com.bariHosh.daoHibernate.ComandaDAOHibernate;
import br.com.bariHosh.entidade.Comanda;
import br.com.bariHosh.entidade.EnumStatusComanda;
import br.com.bariHosh.entidade.Estoque;
import br.com.bariHosh.entidade.ItemComanda;
import br.com.bariHosh.entidade.Usuario;
import br.com.bariHosh.ordenadores.OrdenadorComanda;
import br.com.bariHosh.util.ManuseioPublico;

public class ComandaRN extends ManuseioPublico {

	private ComandaDAOHibernate comandaDAO = new ComandaDAOHibernate();
	private OrdenadorComanda ordenadorComanda;

	public Comanda carregarComanda(Long id) {
		Comanda comanda = new Comanda();
		comanda = this.comandaDAO.carregar(Comanda.class, id);
		if (!super.validaObjeto(comanda)) {
			super.MessagesErro("Comanda não encontrada !");
			return comanda = new Comanda();

		}
		return comanda;
	}

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

	public void atualiza(Comanda comanda) {
		this.comandaDAO.atualizar(comanda);

	}

	public boolean finalizarComanda(Comanda comanda) {
		try {
			Usuario usuarioLogado = super.buscarPorUsuarioLogado();
			if (super.validaObjeto(usuarioLogado.getId_usuario())) {
				// injetando id usuario

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
			EstoqueRN estoqueRN = new EstoqueRN();
			if (super.validaObjeto(comanda.getId_comanda())) {

				for(ItemComanda item : comanda.getItensDaComanda()) {
				Estoque estoque =	estoqueRN.carregarEstoquePorProduto(item.getProduto());
				estoqueRN.aumentarEstoqueProduto(estoque.getProduto(), item.getQuantidade());
				}

				new ComandaDAOHibernate().excluir(comanda);
				super.MessagesSucesso("Comanda Excluido Com Sucesso!");
				return true;
			}
		} catch (Exception e) {
			super.MessagesErro("Ouve erro na tentativa de excluir a comanda contate Administrador do sistema!");
			return false;
		}
		return false;
	}

	public void reativaComanda(Comanda comanda) {
		if (super.validaObjeto(comanda)) {
			this.comandaDAO.atualizar(comanda);
			super.MessagesSucesso("Comanda Reativada   Com Sucesso ");
		} else {
			super.MessagesErro("Ouve erro na tentativa de ativar a comanda contate Administrador do sistema!");
		}

	}

	public ComandaDAOHibernate getComandaDAO() {
		return comandaDAO;
	}

	public void setComandaDAO(ComandaDAOHibernate comandaDAO) {
		this.comandaDAO = comandaDAO;
	}

	public List<Comanda> listaComandasStatus(boolean status) {
		OrdenadorComanda listaOrdenada = new OrdenadorComanda(this.comandaDAO.listaComandasStatus(status,EnumStatusComanda.EM_ABERTO));
		return listaOrdenada.listagemEmOrdem();
	}

	public Comanda recuperaComandaParaEdicao(String id_comanda) {
		String idcomanda = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
				.get(id_comanda);
		if (super.validaObjeto(idcomanda)) {
			return this.comandaDAO.carregar(Comanda.class, Long.parseLong(idcomanda));
		}
		return null;
	}

	public List<Comanda> listaFiltrada(Long id_comanda, String nome) {
		return this.comandaDAO.listaFiltrada(id_comanda, nome);
	}
	
	public List<Comanda> listaFiltradaFechada(Long id_comanda, String nome) {
		return this.comandaDAO.listaFiltradaFechada(id_comanda, nome);
	}

	public OrdenadorComanda getOrdenadorComanda() {
		return ordenadorComanda;
	}

	public void setOrdenadorComanda(OrdenadorComanda ordenadorComanda) {
		this.ordenadorComanda = ordenadorComanda;
	}

}
