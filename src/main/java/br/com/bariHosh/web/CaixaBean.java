package br.com.bariHosh.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.bariHosh.entidade.Cliente;
import br.com.bariHosh.entidade.Comanda;
import br.com.bariHosh.entidade.ItemComanda;
import br.com.bariHosh.entidade.Produto;
import br.com.bariHosh.negocio.ClienteRN;
import br.com.bariHosh.negocio.ComandaRN;
import br.com.bariHosh.negocio.ItemComandaRN;
import br.com.bariHosh.negocio.ProdutoRN;

@ManagedBean(name = "comandaBean")
@RequestScoped
public class CaixaBean {

	private List<Cliente> Clientes ;
	private List<Produto> Produtos;
	private List<ItemComanda> itensComanda;
	private List<Comanda> comandasAbertas;
	private List<Comanda> comandasEncerradas;
	
	private Cliente cliente = new Cliente();
	private Produto produto = new Produto();
	private Comanda comanda = new Comanda();
	private ItemComanda itemComanda = new ItemComanda();
	private String destinoSalvar;
	private ClienteRN clienteRN;
	private ProdutoRN produtoRN;
	private ComandaRN comandaRN;
	private ItemComandaRN itemComandaRN;

	public CaixaBean() {
		this.destinoSalvar = "comanda";
		this.itemComanda = new ItemComanda();
		this.itemComandaRN = new ItemComandaRN();
		this.clienteRN = new ClienteRN();
		this.produtoRN = new ProdutoRN();
		this.comandaRN = new ComandaRN();
		this.comanda.setData(new Date());
	
		

	}
	
	public String editar() {
		return "/restrito/comanda/comanda";
		
	}

	public String salvar() {
		  this.destinoSalvar ="comandasAberto";
		return "/restrito/comanda/comandasAberto2";
	}
	public String novo() {
		this.comanda = new Comanda();
		this.itemComanda = new ItemComanda();
		this.cliente = new Cliente();
		this.destinoSalvar = "comandasAberto";
		this.itemComandaRN = new ItemComandaRN();
		this.clienteRN = new ClienteRN();
		this.produtoRN = new ProdutoRN();
		this.comandaRN = new ComandaRN();
		this.itensComanda = new ArrayList<ItemComanda>() ;
		this.comanda.setData(new Date());
		this.comanda.setCliente(this.cliente);
		this.itemComanda.setProduto(this.produto);
		
		return null;
	}
	public String adicionarItem() {
		this.itemComanda.setValorUnitario(this.itemComanda.getProduto().getValorSaida());
		this.itemComanda.setValorTotal(this.itemComanda.getProduto().getValorSaida()*this.itemComanda.getQuantidade());
		this.comanda.adicionaItemComanda(this.itemComanda);
		if (this.comandaRN.salvar(this.comanda)) {
			this.destinoSalvar = "comanda";
			this.itemComanda = new ItemComanda();
			this.itensComanda = null;
			this.getItensComanda();
		}
		return this.destinoSalvar;

	}

	public String excluir() {
		try {		
		this.comanda.removeItemComanda(this.itemComanda);	
		if (this.comandaRN.salvar(this.comanda)) {
			this.destinoSalvar = "comanda";
			this.itemComanda = new ItemComanda();
			this.itensComanda = null;
			this.getItensComanda();
		}
		System.out.println("testyesssss");
		}catch (Exception e) {
		System.out.println(e.getMessage());
		}
		return "comandasAberto";
	}
	
	public String excluirComanda() {
			
		System.out.println("testyesssss");
		if (this.comandaRN.excluir(this.comanda)) {
		  	System.out.println("testyesssss22"+this.comanda.getId_comanda());
			this.itensComanda = null;
			this.getItensComanda();
		}
		return null;
	}
	

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

	public List<Cliente> getClientes() {
		if (this.Clientes == null ) {
			this.Clientes = clienteRN.listar();
		}
		return Clientes;
	}

	public List<Produto> getProdutos() {
		if (this.Produtos == null) {
			this.Produtos = this.produtoRN.listar();
		}
		return Produtos;
	}
	
	public List<ItemComanda> getItensComanda() {
		if (this.itensComanda == null) {
			if (this.comanda.getId_comanda() != null) {
				this.itensComanda = this.itemComandaRN.listaIntemComandaPorComandaId(this.comanda.getId_comanda());
			}

		}
		return this.itensComanda;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ItemComanda getItemComanda() {
		return itemComanda;
	}

	public void setItemComanda(ItemComanda itemComanda) {
		this.itemComanda = itemComanda;
	}

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	
			

	public List<Comanda> getComandasEncerradas() {
		if (this.comandasEncerradas == null) {
			this.comandasEncerradas = this.comandaRN.listaComandasStatus(false);

		}
		return this.comandasEncerradas;
	}
	

	public List<Comanda> getComandasAbertas() {
		if (this.comandasAbertas == null) {
			this.comandasAbertas = this.comandaRN.listaComandasStatus(true);

		}
		return this.comandasAbertas;
	}
	

	

	

}
