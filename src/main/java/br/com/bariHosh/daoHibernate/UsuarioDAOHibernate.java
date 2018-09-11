package br.com.bariHosh.daoHibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.bariHosh.dao.GenericDAO;
import br.com.bariHosh.entidade.Usuario;
import br.com.bariHosh.util.DAOFactory;

public class UsuarioDAOHibernate implements GenericDAO<Usuario> {

	private Session session = DAOFactory.PegarSession();

	public void salvar(Usuario usuario) {
		this.session.save(usuario);
	}

	public void atualizar(Usuario usuario) {
		if (usuario.getPermissao() == null) {
			Usuario usuarioPermissao = this.carregar(usuario.getIdUsuario());
			usuario.setPermissao(usuarioPermissao.getPermissao());
			this.session.evict(usuarioPermissao);
		}
		this.session.update(usuario);
	}

	public void excluir(Usuario usuario) {
		this.session.delete(usuario);
	}

	public Usuario carregar(Integer idUsuario) {
		return (Usuario) this.session.get(Usuario.class, idUsuario);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listar() {
		return this.session.createCriteria(Usuario.class).list();
	}

	public Usuario buscarPorLogin(String login) {
		String hql = "select u from Usuario u where u.login = :login";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("login", login);
		return (Usuario) consulta.uniqueResult();
	}
}
