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

	
	
	
	public void salvar(Cliente cliente) {		
		Usuario usuariologado = super.buscarPorUsuarioLogado();	
		if(super.validaObjeto(usuariologado)) {
			    cliente.getPessoa().setId_usuario_criacao(usuariologado.getId_usuario());			
			if (!super.validaObjeto(cliente.getId_cliente())) {	
				cliente.getPessoa().setDt_criacao(new Date());
				this.clienteDAO.salvar(cliente);
			} else {
				cliente.getPessoa().setDt_alteracao(new Date());
				this.clienteDAO.atualizar(cliente);
			}
		}
		
		
	}

	public void excluir(Cliente cliente) {		
		if (super.validaObjeto(cliente.getId_cliente())) {			
			this.clienteDAO.excluir(cliente);
		} 
		
	}

	public List<Cliente> listar() {
		return this.clienteDAO.listar(Cliente.class);
	}
}


