package br.com.bariHosh.dao;
import br.com.bariHosh.entidade.EnumPermissao;
import br.com.bariHosh.entidade.Usuario;

public interface UsuarioDAO {
	
	public Usuario buscarPorLogin(String login);
	public Usuario buscarPorPermissao(EnumPermissao permissao);
	public void atualizar_permissao(Usuario usuario);
	
	
	
}
