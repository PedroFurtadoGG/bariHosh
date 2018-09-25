package br.com.bariHosh.negocio;

import java.util.List;

import br.com.bariHosh.daoHibernate.ClienteDAOHibernate;
import br.com.bariHosh.entidade.Cliente;

public class ClienteRN {

	
	private ClienteDAOHibernate clienteDAO;

	public ClienteRN() {
		this.clienteDAO = new ClienteDAOHibernate();
	}
	
	public Cliente carregar(Long id) {
		return this.clienteDAO.carregar(Cliente.class,id);
	}

	
	
	
	public void salvar(Cliente cliente) {
		Long clienteID = cliente.getId_cliente();
		if (clienteID == null || clienteID == 0) {			
			this.clienteDAO.salvar(cliente);
		} else {
			this.clienteDAO.atualizar(cliente);
		}
	}

	public void excluir(Cliente cliente) {
		Long clienteID = cliente.getId_cliente();
		if (clienteID != null || clienteID != 0) {			
			this.clienteDAO.excluir(cliente);
		} 
		
	}

	public List<Cliente> listar() {
		return this.clienteDAO.listar(Cliente.class);
	}
}


