package br.com.bariHosh.negocio;

import java.util.Date;
import java.util.List;

import br.com.bariHosh.daoHibernate.UsuarioDAOHibernate;
import br.com.bariHosh.entidade.Usuario;
import br.com.bariHosh.util.ManuseioPublico;

public class UsuarioRN extends ManuseioPublico {

	private UsuarioDAOHibernate daoUsuario;

	public UsuarioRN() {
		this.daoUsuario = new UsuarioDAOHibernate();

	}

	public Usuario carregar(Long id) {
		return this.daoUsuario.carregar(Usuario.class, id);
	}

	public Usuario buscarPorLogin(String login) {
		return this.daoUsuario.buscarPorLogin(login);
	}

	

	public void salvar(Usuario usuario) {		
		Usuario usuarioLogado = super.buscarPorUsuarioLogado();
		if (super.validaObjeto(usuarioLogado.getId_usuario())) {
			usuario.getPessoa().setId_usuario_criacao(usuarioLogado.getId_usuario());
			usuario.setLogin(usuario.getPessoa().getEmail());

			if (!super.validaObjeto(usuario.getId_usuario())) {
				usuario.getPessoa().setDt_criacao(new Date());
				this.daoUsuario.salvar(usuario);
			} else {
				usuario.getPessoa().setDt_alteracao(new Date());
				this.daoUsuario.atualizar(usuario);
			}

		} 

	}

	public void excluir(Usuario usuario) {
		if (super.validaObjeto(usuario.getId_usuario())) {
		this.daoUsuario.excluir(usuario);
		}
	}

	public List<Usuario> listar() {
		return this.daoUsuario.listar(Usuario.class);
	}

}
