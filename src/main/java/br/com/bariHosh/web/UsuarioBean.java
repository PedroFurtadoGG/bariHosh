package br.com.bariHosh.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.bariHosh.entidade.Endereco;
import br.com.bariHosh.entidade.EnumPermissao;
import br.com.bariHosh.entidade.EnumSexo;
import br.com.bariHosh.entidade.Pessoa;
import br.com.bariHosh.entidade.Usuario;
import br.com.bariHosh.negocio.UsuarioRN;
import br.com.bariHosh.util.ManuseioPublico;

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
	private EnumSexo enumSexo;
	private UsuarioRN usuarioRN;
	private String teste;

	public UsuarioBean() {	
	    this.teste = "userrrr";
		this.destinoSalvar = "usuarios";
		this.usuarioRN = new UsuarioRN();
		this.endereco = new Endereco();
		this.pessoa.setEndereco(endereco);
		this.usuario.setPessoa(pessoa);
		this.usuario.setAtivo(true);

	}

	public String novo() {		
		this.usuarioRN = new UsuarioRN();
		this.pessoa = new Pessoa();
		this.usuario = new Usuario();
		this.endereco = new Endereco();
		this.pessoa.setEndereco(endereco);
		this.usuario.setPessoa(pessoa);
		this.usuario.setAtivo(true);
		return "/restrito/usuario/usuario";
	}

	@PostConstruct
	public void init() {

	}

	public String entrar() {
		return "/index";
	}

	public String editar() {
		this.confirmarSenha = this.usuario.getSenha();	
		return "/restrito/usuario/usuario";

	}
	
	



	public String salvar() {		
		if (!usuario.getSenha().equals(this.confirmarSenha)) {
			ManuseioPublico.MessagesErro("A senha no foi confirmada corretamente!");
			return null;
		}
		if (usuarioRN.salvar(this.usuario) ) {	
			return this.destinoSalvar;
		}
		return null;
	}

	public String limpar() {
		return this.destinoSalvar;
	}

	public String excluir() {
		usuarioRN.excluir(this.usuario);
		this.lista = null;
		return null;
	}

	public String ativar() {
		if (this.usuario.isAtivo())
			this.usuario.setAtivo(false);
		else
			this.usuario.setAtivo(true);

		usuarioRN.salvar(this.usuario);
		return null;
	}


	public List<Usuario> getLista() {
		if (this.lista == null) {
			this.lista = usuarioRN.listar();
		}
		return this.lista;
	}

	public void setLista(List<Usuario> lista) {
		this.lista = lista;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public EnumPermissao getEnumpemrmissao() {
		return enumpemrmissao;
	}

	public void setEnumpemrmissao(EnumPermissao enumpemrmissao) {
		this.enumpemrmissao = enumpemrmissao;
	}

	public EnumPermissao[] getEnumPermissoes() {
		return EnumPermissao.values();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@SuppressWarnings("static-access")
	public EnumSexo[] getEnumSexo() {
		return enumSexo.values();
	}

	public void setEnumSexo(EnumSexo enumSexo) {
		this.enumSexo = enumSexo;
	}

	public String getTeste() {
		return teste;
	}

	public void setTeste(String teste) {
		this.teste = teste;
	}

	

}
