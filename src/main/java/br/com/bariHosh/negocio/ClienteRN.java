package br.com.bariHosh.negocio;

import java.util.Date;
import java.util.List;

import br.com.bariHosh.daoHibernate.ClienteDAOHibernate;
import br.com.bariHosh.entidade.Cliente;
import br.com.bariHosh.entidade.Usuario;
import br.com.bariHosh.util.ManuseioPublico;

public class ClienteRN  extends ManuseioPublico{

	
	private ClienteDAOHibernate clienteDAO;

	public ClienteRN() {
		this.clienteDAO = new ClienteDAOHibernate();
	}
	
	public Cliente carregar(Long id) {
		return this.clienteDAO.carregar(Cliente.class,id);
	}

	
	
	public boolean salvar(Cliente cliente) {

		try {
			if (super.isCPF(cliente.getPessoa().getCpf())) {
				if (super.CalcularIdade(cliente.getPessoa().getDt_nascimento())) {
					Usuario usuarioLogado = super.buscarPorUsuarioLogado();
					if (super.validaObjeto(usuarioLogado.getId_usuario())) {
						cliente.getPessoa().setId_usuario_criacao(usuarioLogado.getId_usuario());
						if (!super.validaObjeto(cliente.getId_cliente())) {
							cliente.getPessoa().setDt_criacao(new Date());
							this.clienteDAO.salvar(cliente);
						} else {
							cliente.getPessoa().setDt_alteracao(new Date());
							this.clienteDAO.atualizar(cliente);
						}
						super.MessagesSucesso("Cliente Salvo Com Sucesso !");
						return true;

					} else {
						super.MessagesErro("E Necessario Estar Logado!");
						return false;
					}
				} else {
					super.MessagesErro("A Idade e Inferior a 18 anos!");
					return false;
				}
			} else {
				super.MessagesErro(" Cpf Invalido!");
				cliente.getPessoa().setCpf("");
				return false;
			}

		} catch (Exception e) {
			System.out.println("erro salvar" + e.getMessage());
			super.MessagesErro(
					"Ouve erro na tentativa de salvar o cliente Verifique os campos Obrigatorios e tente novamente!");

		}
		return false;
	}

	public void excluir(Cliente cliente) {	
		try {
		if (super.validaObjeto(cliente.getId_cliente())) {			
			this.clienteDAO.excluir(cliente);
			super.MessagesSucesso("cliente Excluido Com Sucesso!");
		   } 
		} catch (Exception e) {
			System.out.println("erro excluir" + e.getMessage());
			super.MessagesErro(
					"Ouve erro na tentativa de excluir o cliente Verifique os campos Obrigatorios e tente novamente!");

		}
		
	}

	public List<Cliente> listar() {
		return this.clienteDAO.listar(Cliente.class);
	}
}


