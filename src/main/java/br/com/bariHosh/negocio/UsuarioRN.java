package br.com.bariHosh.negocio;

import java.util.List;
import java.util.Objects;

import br.com.bariHosh.daoHibernate.PessoaDAOHibernate;
import br.com.bariHosh.daoHibernate.UsuarioDAOHibernate;
import br.com.bariHosh.entidade.Pessoa;
import br.com.bariHosh.entidade.Usuario;

public class UsuarioRN extends ManuseioPublico {

	private UsuarioDAOHibernate daoUsuario;
    private PessoaDAOHibernate daoPessoa;
	public UsuarioRN() {
		this.daoUsuario = new UsuarioDAOHibernate();
		this.daoPessoa =  new PessoaDAOHibernate();
		
	}

	public Usuario carregar(Long id) {
		return this.daoUsuario.carregar(Usuario.class,id);
	}

	public Usuario buscarPorLogin(String login) {
		return this.daoUsuario.buscarPorLogin(login);
	}

	public void salvar(Usuario usuario) {			
		if (Objects.isNull(usuario.getLogin())) {
			usuario.setLogin(usuario.getPessoa().getEmail());	        
		}		
		if (Objects.isNull(usuario.getId_usuario())) {
			
			Pessoa pessoa = usuario.getPessoa();
			this.daoPessoa.salvar(pessoa);
			usuario.setPessoa(pessoa);
			this.daoUsuario.salvar(usuario);
		}else {
			
			System.out.println(""+usuario.getPessoa().getId_pessoa());
			System.out.println(""+usuario.getPessoa().getEndereco().getId_endereco());
			this.daoPessoa.atualizar(usuario.getPessoa());
			this.daoUsuario.atualizar(usuario);
			
		}
		
	}

	public void excluir(Usuario usuario) {
		this.daoUsuario.excluir(usuario);
	}

	public List<Usuario> listar() {
		return this.daoUsuario.listar(Usuario.class);
	}

	
}
