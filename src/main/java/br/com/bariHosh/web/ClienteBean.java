package br.com.bariHosh.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.bariHosh.entidade.Cliente;
import br.com.bariHosh.entidade.Endereco;
import br.com.bariHosh.entidade.EnumSexo;
import br.com.bariHosh.entidade.Pessoa;
import br.com.bariHosh.negocio.ClienteRN;

@ManagedBean(name = "clienteBean")
@RequestScoped
public class ClienteBean {
	
	private Cliente cliente = new Cliente();
	private Pessoa pessoa = new Pessoa();
    private Endereco endereco = new Endereco();
	private List<Cliente> lista;
	private String destinoSalvar;
	private EnumSexo enumSexo;
	
	public String novo() {
		this.destinoSalvar = "clientes";
		this.setPessoa(new Pessoa());
		this.cliente = new Cliente();
		this.endereco = new Endereco();
		this.pessoa.setEndereco(endereco);
		this.cliente.setPessoa(pessoa);
		this.cliente.setAtivo(true);
		return "/publico/cliente/cliente";
	}
	
	@PostConstruct
	public void init() {
		this.destinoSalvar = "clientes";
		this.setPessoa(new Pessoa());
		this.cliente = new Cliente();
		this.endereco = new Endereco();
		this.pessoa.setEndereco(endereco);
		this.cliente.setPessoa(pessoa);
		this.cliente.setAtivo(true);
		
	}

	public String editar() {		
		return "/publico/cliente/cliente";
		
	}
	

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setLista(List<Cliente> lista) {
		this.lista = lista;
	}

	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();	
		ClienteRN clienteRN = new ClienteRN();	
		clienteRN.salvar(this.cliente);
		return this.destinoSalvar;
	}

	public String excluir() {
		ClienteRN clienteRN = new ClienteRN();	
		clienteRN.excluir(this.cliente);
		System.out.println("teste");
		this.lista = null;
		return null;
	}

	public String ativar() {
		if (this.cliente.isAtivo())
			this.cliente.setAtivo(false);
		else
			this.cliente.setAtivo(true);

		ClienteRN clienteRN = new ClienteRN();	
		clienteRN.salvar(this.cliente);
		return null;
	}

	public List<Cliente> getLista() {
		if (this.lista == null) {
			ClienteRN clienteRN = new ClienteRN();
			this.lista = clienteRN.listar();
		}
		return this.lista;
	}

	
	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public EnumSexo[] getEnumSexo() {
		return EnumSexo.values();
	}

	public void setEnumSexo(EnumSexo enumSexo) {
		this.enumSexo = enumSexo;
	}

}
