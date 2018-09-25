package br.com.bariHosh.negocio;

import java.util.List;
import java.util.Objects;

import br.com.bariHosh.daoHibernate.GenericoDAOHibernate;
import br.com.bariHosh.daoHibernate.UsuarioDAOHibernate;
import br.com.bariHosh.entidade.Usuario;

public class UsuarioRN extends ManuseioPublico {
	private GenericoDAOHibernate<Usuario> dao;
	private UsuarioDAOHibernate usuarioDAO;

	public UsuarioRN() {
		this.usuarioDAO = new UsuarioDAOHibernate();
		this.dao = new GenericoDAOHibernate<Usuario>();
	}

	public Usuario carregar(Long id) {
		return this.dao.carregar(Usuario.class,id);
	}

	public Usuario buscarPorLogin(String login) {
		return this.usuarioDAO.buscarPorLogin(login);
	}

	public void salvar(Usuario usuario) {

		if (Objects.isNull(usuario.getLogin())) {
			usuario.setLogin(usuario.getPessoa().getEmail());
			this.dao.salvar(usuario);
		}
		
		if (!Objects.isNull(usuario.getId_usuario())) {
			this.dao.atualizar(usuario);
		}
		
	}

	public void excluir(Usuario usuario) {
		this.usuarioDAO.excluir(usuario);
	}

	public List<Usuario> listar() {
		return this.usuarioDAO.listar(Usuario.class);
	}
}
