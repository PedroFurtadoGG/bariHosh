package br.com.bariHosh.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.bariHosh.entidade.Endereco;
import br.com.bariHosh.entidade.EnumPermissao;
import br.com.bariHosh.entidade.Pessoa;
import br.com.bariHosh.entidade.Usuario;
import br.com.bariHosh.negocio.UsuarioRN;

@ManagedBean(name = "usuarioBean")
@RequestScoped
public class UsuarioBean {
	private Usuario usuario = new Usuario();
	private Pessoa pessoa = new Pessoa();
	private Endereco endereco = new Endereco();
	private String confirmarSenha;
	private List<Usuario> lista;
	private String destinoSalvar;
	
    private EnumPermissao enumpemrmissao;
	public String novo() {
		this.destinoSalvar = "usuariosucesso";
		this.pessoa = new Pessoa();
		this.usuario = new Usuario();
		this.endereco = new Endereco();
		this.pessoa.setEndereco(endereco);
		this.usuario.setPessoa(pessoa);
		
		
		this.usuario.setAtivo(true);
		return "/publico/usuario";
	}
	
	@PostConstruct
	public void init() {
		this.destinoSalvar = "usuariosucesso";
		this.pessoa = new Pessoa();
		this.usuario = new Usuario();
		this.endereco = new Endereco();
		this.pessoa.setEndereco(endereco);
		this.usuario.setPessoa(pessoa);
    }
	
	
	
	public String entrar() {		
		return "/index";
	}
	
	public String cadastraFornecedor() {		
		return "/fornecedor";
	}
	public String editar() {
		this.confirmarSenha = this.usuario.getSenha();
		return "/publico/usuario";
		
	}

	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();

		String senha = this.usuario.getSenha();
		if (!senha.equals(this.confirmarSenha)) {
			FacesMessage facesMessage = new FacesMessage("A senha não foi confirmada corretamente");
			context.addMessage(null, facesMessage);
			return null;
		}

		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.salvar(this.usuario);

		return this.destinoSalvar;
	}
	
	public String limpar() {
		

		return this.destinoSalvar;
	}

	public String excluir() {
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.excluir(this.usuario);
		this.lista = null;
		return null;
	}

	public String ativar() {
		if (this.usuario.isAtivo())
			this.usuario.setAtivo(false);
		else
			this.usuario.setAtivo(true);

		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.salvar(this.usuario);
		return null;
	}

	public List<Usuario> getLista() {
		if (this.lista == null) {
			UsuarioRN usuarioRN = new UsuarioRN();
			this.lista = usuarioRN.listar();
		}
		return this.lista;
	}

	public String atribuiPermissao(Usuario usuario, String permissao) {
		this.usuario = usuario;
		EnumPermissao permissoes = this.usuario.getPermissao();
		if (permissoes.name().contains(permissao)) {
			
		} else {
			permissoes.chave = permissao;
			this.usuario.setPermissao(permissoes);
		}
		return null;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

	

	

	public EnumPermissao[] getEnumpemrmissao() {
		return enumpemrmissao.values();
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	

}
