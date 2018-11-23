package br.com.bariHosh.web;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.bariHosh.entidade.Usuario;
import br.com.bariHosh.negocio.UsuarioRN;

@ManagedBean(name = "topMenuBean")
@RequestScoped
public class TopMenuBean {

	private Usuario UsuarioAutenticado;
	private String usuarioNome;
	private UsuarioRN usuarioRN ;

	public TopMenuBean() {
		this.usuarioRN = new UsuarioRN();
		this.UsuarioAutenticado = new Usuario();
		this.usuarioNome = new String();
		PegarUsuarioAutenticado(); 		
		this.usuarioNome = UsuarioAutenticado.getPessoa().getNome();
	}

	@PostConstruct
	public void init() {

	}

	public String salvar() {

		return "";
	}

	public String excluir() {

		return null;
	}

	public String editar() {

		return null;
	}

	public void PegarUsuarioAutenticado() {
		this.setUsuarioAutenticado(usuarioRN.buscarPorUsuarioLogado());

	}

	public Usuario getUsuarioAutenticado() {
		return UsuarioAutenticado;
	}

	public void setUsuarioAutenticado(Usuario usuarioAutenticado) {
		UsuarioAutenticado = usuarioAutenticado;
	}

	public String getUsuarioNome() {
		return usuarioNome;
	}

	public void setUsuarioNome(String usuarioNome) {
		this.usuarioNome = usuarioNome;
	}

}
