package br.com.bariHosh.negocio;

import java.util.List;

import br.com.bariHosh.dao.AbstratoModeloDAO;
import br.com.bariHosh.daoHibernate.GenericoDAOHibernate;
import br.com.bariHosh.daoHibernate.UsuarioDAOHibernate;
import br.com.bariHosh.entidade.EnumPermissao;
import br.com.bariHosh.entidade.Pessoa;
import br.com.bariHosh.entidade.Usuario;
import br.com.bariHosh.util.DAOFactory;

public class UsuarioRN extends ManuseioPublico {
	private GenericoDAOHibernate<Usuario> dao;
	private UsuarioDAOHibernate usuarioDAO;

	public void validaDados() {
//		ManuseioPublico.isCPF(Usuario);
	}

	public UsuarioRN() {
		this.usuarioDAO = new UsuarioDAOHibernate();
		this.dao = new GenericoDAOHibernate<Usuario>();
	}

	public Usuario carregar(Long id) {
		return this.dao.carregar(id);
	}

	public Usuario buscarPorLogin(String login) {
		return this.usuarioDAO.buscarPorLogin(login);
	}

	public void salvar(Usuario usuario) {
		Long usuarioId = usuario.getId_usuario();
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
