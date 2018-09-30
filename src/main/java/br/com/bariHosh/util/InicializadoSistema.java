package br.com.bariHosh.util;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bariHosh.daoHibernate.UsuarioDAOHibernate;
import br.com.bariHosh.entidade.Endereco;
import br.com.bariHosh.entidade.EnumPermissao;
import br.com.bariHosh.entidade.EnumSexo;
import br.com.bariHosh.entidade.Pessoa;
import br.com.bariHosh.entidade.Usuario;


@Startup
@Singleton
public class InicializadoSistema {

	@Service("inicializadorSistema")
	public class InicializadorSistema {

		@Autowired
		private UsuarioDAOHibernate usuarioDao;

		

		@PostConstruct
		public void iniciar() {
			inicializarUsuarioAdmin();
		}

		private void inicializarUsuarioAdmin() {
			try {
				List<Usuario> usuarios = usuarioDao.listar(Usuario.class);
				if (usuarios.isEmpty()) {
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
					usuarioDao.salvar(user);


				}
			} catch (Exception e) {

			}
		}

	}
	
	
}
