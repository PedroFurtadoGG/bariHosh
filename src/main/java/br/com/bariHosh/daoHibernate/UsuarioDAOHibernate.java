package br.com.bariHosh.daoHibernate;

import org.hibernate.Query;
import org.hibernate.Session;
import br.com.bariHosh.dao.UsuarioDAO;
import br.com.bariHosh.entidade.EnumPermissao;
import br.com.bariHosh.entidade.Usuario;
import br.com.bariHosh.util.DAOFactory;

public class UsuarioDAOHibernate extends GenericoDAOHibernate<Usuario> implements UsuarioDAO {

	private Session session = DAOFactory.PegarSession();

	@Override
	public void atualizar_permissao(Usuario usuario) {
		if (usuario.getPermissao() == null) {
			Usuario usuarioPermissao = this.carregar(Usuario.class,usuario.getId_usuario());
			usuario.setPermissao(usuarioPermissao.getPermissao());
			this.session.evict(usuarioPermissao);
		}
		this.session.update(usuario);
	}
	
	@Override
	public Usuario buscarPorLogin(String login) {
		String hql = "select u from Usuario u where u.login = :login";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("login", login);
		return (Usuario) consulta.uniqueResult();
	}

	@Override
	public Usuario buscarPorPermissao(EnumPermissao permissao) {
		// TODO Auto-generated method stub
		return null;
	}
}
