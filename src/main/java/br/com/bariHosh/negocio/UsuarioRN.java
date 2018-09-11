package br.com.bariHosh.negocio;

import java.util.List;

import br.com.bariHosh.daoHibernate.GenericDAOHibernate;
import br.com.bariHosh.daoHibernate.UsuarioDAOHibernate;
import br.com.bariHosh.entidade.EnumPermissao;
import br.com.bariHosh.entidade.Usuario;

public class UsuarioRN {
	private GenericDAOHibernate<Usuario> dao;

	private UsuarioDAOHibernate usuarioDAO;

	public UsuarioRN() {
		this.usuarioDAO = new UsuarioDAOHibernate();
		this.dao = new GenericDAOHibernate<Usuario>();
	}

	public Usuario carregar(Integer id) {
		return this.dao.carregar(id);
	}

	public Usuario buscarPorLogin(String login) {
		return this.usuarioDAO.buscarPorLogin(login);
	}

	public void salvar(Usuario usuario) {
		Integer usuarioId = usuario.getIdUsuario();
		if (usuarioId == null || usuarioId == 0) {
			usuario.setPermissao(EnumPermissao.ROLE_ADMINISTRADOR);
			this.dao.salvar(usuario);
		} else {
			this.dao.atualizar(usuario);
		}
	}

	public void excluir(Usuario usuario) {
		this.usuarioDAO.excluir(usuario);
	}

	public List<Usuario> listar() {
		return this.usuarioDAO.listar();
	}
}
