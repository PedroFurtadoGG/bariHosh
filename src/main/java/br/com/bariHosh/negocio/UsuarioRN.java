package br.com.bariHosh.negocio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

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


	

	public boolean salvar(Usuario usuario) {

		try {
			if (this.calculaIdadeReal(usuario.getPessoa().getDt_nascimento())) {
				Usuario usuarioLogado = super.buscarPorUsuarioLogado();
				if (super.validaObjeto(usuarioLogado.getId_usuario())) {
					usuario.getPessoa().setId_usuario_criacao(usuarioLogado.getId_usuario());
					usuario.setLogin(usuario.getPessoa().getEmail());
					Usuario user = this.buscarPorLogin(usuario.getLogin());
					if (!super.validaObjeto(user)) {
						if (!super.validaObjeto(usuario.getId_usuario())) {
							usuario.getPessoa().setDt_criacao(new Date());
							this.daoUsuario.salvar(usuario);
						} else {
							usuario.getPessoa().setDt_alteracao(new Date());
							this.daoUsuario.atualizar(usuario);
						}
						super.MessagesSucesso("Usuario Salvo Com Sucesso!");
						return true;
					} else if (user.getId_usuario().equals(usuario.getId_usuario())) {
						usuario.getPessoa().setDt_alteracao(new Date());
						this.daoUsuario.atualizar(usuario);
						super.MessagesSucesso("Usuario Atualizado Com Sucesso!");
						return true;

					} else {
						super.MessagesErro("Email ja cadastrado no sistema !");
						return false;
					}

				} else {
					super.MessagesErro("E necessario Estar Logado ");

					return false;
				}
			} else {
				super.MessagesErro("A Idade e Inferior a 18 anos");
				return false;
			}

		} catch (Exception e) {
			System.out.println("erro salvar" + e.getMessage());
			super.MessagesErro(
					"Ouve erro na tentativa de salvar o usuario Verifique os campos Obrigatorios e tente novamente");

		}
		return false;
	}

	public boolean calculaIdadeReal(Date data) {
		if (super.CalcularIdade(data) >= 18) {
			return true;
		}
		return false;
	}

	public void excluir(Usuario usuario) {
		if (super.validaObjeto(usuario.getId_usuario())) {
			this.daoUsuario.excluir(usuario);
			super.MessagesSucesso("Usuario Excluido Com Sucesso!");
		}
	}

	public List<Usuario> listar() {
		return this.daoUsuario.listar(Usuario.class);
	}

}
