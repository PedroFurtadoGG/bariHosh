package br.com.bariHosh.teste;

import java.util.Date;
import java.util.Scanner;

import br.com.bariHosh.entidade.Endereco;
import br.com.bariHosh.entidade.EnumPermissao;
import br.com.bariHosh.entidade.Usuario;
import br.com.bariHosh.negocio.UsuarioRN;

public class test {

	public static void main(String[] args) {
	
		System.out.println("digite 1");
		int num = new Scanner(System.in).nextInt();
		if(num == 1) {
			
			stats();
		}else {
			
			System.out.println("errou digite  1");
		}
		
		
	}
	
	public static void stats() {

		Usuario u = new Usuario();
		
		u.setCpf("031.128.951.77");
		u.setNome("jose");
		u.setRg("0000000");
		u.setAtivo(true);
		u.setDt_nascimento(new Date());
		u.setEmail("isso@gmail.com");	
		u.setIdioma("portugues");
		u.setSexo("maxu");
		u.setTelefone("1111111111");
		u.setPermissao(EnumPermissao.ROLE_ADMINISTRADOR);
		u.setDt_criacao(new Date());
		u.setDt_alteracao(new Date());
		u.setLogin("jose");
		u.setSenha("1234");
		
		
		Endereco end = new Endereco();
		end.setEndereco("rua jamaica");
		end.setBairro("centro");
		end.setCidade("goiania");
		end.setPais("brazil");
		u.setEndereco(end);
		
		UsuarioRN usua = new UsuarioRN();
		usua.salvar(u);

		
	}

}
