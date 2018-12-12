package br.com.bariHosh.daoHibernate;

import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.bariHosh.dao.UsuarioDAO;
import br.com.bariHosh.entidade.EnumPermissao;
import br.com.bariHosh.entidade.Usuario;
import br.com.bariHosh.util.DAOFactory;
import br.com.bariHosh.util.ManuseioPublico;

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
		
		return null;
	}

	@Override
	public Usuario buscarUsuarioLogado() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		String login = external.getRemoteUser();
		return this.buscarPorLogin(login);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listaCompleta() {
		String hql = "select u from Usuario u  "
				+ " JOIN FETCH u.pessoa p ";
			 					
		Query consulta = this.session.createQuery(hql);
		List<Usuario> list = (List<Usuario> ) consulta.list();
		
		return list;		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listaFiltrada(String nome, Long id_usuario, String email) {
		StringBuffer hql = new StringBuffer();

		hql.append("select u from Usuario u LEFT JOIN FETCH u.pessoa p where 1=1 ");
		
		if(ManuseioPublico.validaObjeto(nome)) {
			hql.append(" and p.nome like '%" + nome + "%' ");
		}
		
		if(ManuseioPublico.validaObjeto(email)) {
			hql.append(" and p.email like '%" + email + "%' ");
		}


		if (ManuseioPublico.validaObjeto(id_usuario)) {
			hql.append("and u.id_usuario = " + id_usuario + " ");
		}

		Query consulta = this.session.createQuery(hql.toString());
		List<Usuario> listaFiltrada = (List<Usuario>) consulta.list();
		
		return listaFiltrada;
	}

}
