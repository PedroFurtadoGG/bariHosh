package br.com.bariHosh.teste;

import java.util.Date;
import java.util.Scanner;

import br.com.bariHosh.daoHibernate.UsuarioDAOHibernate;
import br.com.bariHosh.entidade.Endereco;
import br.com.bariHosh.entidade.EnumPermissao;
import br.com.bariHosh.entidade.EnumSexo;
import br.com.bariHosh.entidade.Pessoa;
import br.com.bariHosh.entidade.Usuario;
import br.com.bariHosh.negocio.UsuarioRN;

public class test {

	public static void main(String[] args) {
	
		System.out.println("digite 1");
		@SuppressWarnings("resource")
		int num = new Scanner(System.in).nextInt();
		if(num == 1) {
			
			stats();
		}else {
			
			System.out.println("errou digite  1");
		}
		
		
	}
	
	public static void stats() {

		Usuario user = new Usuario();
		Pessoa pessoa = new Pessoa();
		Endereco end = new Endereco();
		pessoa.setEndereco(end);
		
		user.setPessoa(pessoa);
		user.getPessoa().setNome("ADMINISTRADOR");
		user.getPessoa().setCpf("000.000.000.00");
		user.getPessoa().setRg("0000000");
		user.getPessoa().setEmail("ADMINISTRADOR@GMAIL.COM");
		user.getPessoa().setTelefone("1111111111");
		user.getPessoa().setDt_nascimento(new java.sql.Date(new Date().getTime()));
		user.getPessoa().setDt_criacao(new java.sql.Date(new Date().getTime()));
		user.setPermissao(EnumPermissao.ROLE_ADMINISTRADOR);
		user.getPessoa().setSexo(EnumSexo.M.chave);
		user.setLogin(pessoa.getEmail());
		user.setSenha("1234");
		user.setAtivo(true);					
		
		
		UsuarioDAOHibernate usua = new UsuarioDAOHibernate();
		usua.salvar(user);

		
	}

}
