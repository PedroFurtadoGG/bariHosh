package br.com.bariHosh.dao;

import java.util.List;

import br.com.bariHosh.entidade.EnumPermissao;
import br.com.bariHosh.entidade.Usuario;

public interface UsuarioDAO {

	public Usuario buscarPorLogin(String login);

	public Usuario buscarPorPermissao(EnumPermissao permissao);

	public void atualizar_permissao(Usuario usuario);

	public Usuario buscarUsuarioLogado();

	public List<Usuario> listaCompleta();

	public List<Usuario> listaFiltrada(String nome, Long id_usuario, String email);

}
