package br.com.bariHosh.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.bariHosh.entidade.Cliente;
import br.com.bariHosh.entidade.Comanda;
import br.com.bariHosh.entidade.ItemComanda;
import br.com.bariHosh.entidade.Produto;
import br.com.bariHosh.negocio.ClienteRN;
import br.com.bariHosh.negocio.ComandaRN;
import br.com.bariHosh.negocio.ItemComandaRN;
import br.com.bariHosh.negocio.ProdutoRN;
import br.com.bariHosh.util.ManuseioPublico;

@ManagedBean(name = "comandaBean")
@ViewScoped
public class ComandaBean implements Serializable {

	private static final long serialVersionUID = 5157727053904987775L;
	private List<Cliente> Clientes;
	private List<Produto> Produtos;
	private List<Comanda> comandasAbertas;
	private List<Comanda> comandasEncerradas;
	private List<ItemComanda> itensComanda;
	private Cliente cliente = new Cliente();
	private Produto produto = new Produto();
	private Comanda comanda = new Comanda();
	private ItemComanda itemComanda = new ItemComanda();

	private String destinoSalvar;
	private ClienteRN clienteRN = new ClienteRN();
	private ProdutoRN produtoRN = new ProdutoRN();
	private ComandaRN comandaRN = new ComandaRN();
	private ItemComandaRN itemComandaRN = new ItemComandaRN();

	@PostConstruct
	public void init() {
		this.itensComanda = new ArrayList<ItemComanda>();
		this.itemComanda = new ItemComanda();
		this.itemComanda.setComanda(this.comanda);
		this.itemComanda.setProduto(this.produto);
		this.clienteRN = new ClienteRN();
		this.produtoRN = new ProdutoRN();
		this.comandaRN = new ComandaRN();
		this.itemComandaRN = new ItemComandaRN();
		Comanda comanda = this.comandaRN.recuperaComandaParaEdicao();
		if (comanda != null) {
			this.comanda = comanda;
		}

	}

	public String novo() {
		
		this.itensComanda = new ArrayList<ItemComanda>();
		this.itemComanda = new ItemComanda();
		this.itemComanda.setComanda(this.comanda);
		this.itemComanda.setProduto(this.produto);
		this.clienteRN = new ClienteRN();
		this.produtoRN = new ProdutoRN();
		this.comandaRN = new ComandaRN();
		this.itemComandaRN = new ItemComandaRN();
		

		return "comanda";
	}

	public void adicionarItemComanda() {
		
		this.itemComanda.setValorUnitario(this.itemComanda.getProduto().getValorSaida());
		this.itemComanda
				.setValorTotal(this.itemComanda.getProduto().getValorSaida() * this.itemComanda.getQuantidade());
		this.comanda.adicionaItemComanda(this.itemComanda);
		ManuseioPublico.MessagesSucesso("Item adicionado com Sucesso !");
		this.itemComanda = new ItemComanda();

	}

	public void excluirItemComanda() {
		this.comanda.removeItemComanda(this.itemComanda);
		if (this.comanda.getId_comanda() != null) {
			new ItemComandaRN().excluir(this.itemComanda);
		}else {
			ManuseioPublico.MessagesSucesso("Item Removido  com Sucesso !");
		}
		
	}

	public void excluirComanda(Comanda comanda) {
		this.comanda = comanda;
		this.destinoSalvar = "comandasAberto";
		if (new ComandaRN().excluir(this.comanda)) {
           this.comanda = new Comanda();
           this.comandasAbertas = null;
		}

	}

	public String editarComanda(Comanda comanda) {
		this.comanda = comanda;
		this.destinoSalvar = "comanda";
		return this.destinoSalvar;

	}

	public String salvarComanda() {
		this.comandaRN = new ComandaRN();
		if (this.comandaRN.salvar(this.comanda)) {
			this.comanda = new Comanda();
			this.destinoSalvar = "comandasAberto";
		}
		return this.destinoSalvar;
	}

	public List<Cliente> getClientes() {	
		if (this.Clientes == null) {
			this.Clientes = new ClienteRN().listar();
		}
		return this.Clientes;
	}

	public List<Produto> getProdutos() {
		if (this.Produtos == null) {
			this.Produtos = new ProdutoRN().listar();
		}
		return this.Produtos;
	}

	public List<ItemComanda> getItensComanda() {
		return this.itensComanda;
	}

	public List<Comanda> getComandasEncerradas() {
		if (this.comandasEncerradas == null) {
			this.comandasEncerradas = this.comandaRN.listaComandasStatus(false);
		}
		return this.comandasEncerradas;
	}

	public List<Comanda> getComandasAbertas() {
		if (this.comandasAbertas == null) {
			this.comandasAbertas = new ComandaRN().listaComandasStatus(true);
		}
		return this.comandasAbertas;

	}

	public void setItensComanda(List<ItemComanda> itensComanda) {
		this.itensComanda = itensComanda;
	}

	public Comanda getComanda() {		
		return this.comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	public ItemComanda getItemComanda() {
		return itemComanda;
	}

	public void setItemComanda(ItemComanda itemComanda) {
		this.itemComanda = itemComanda;
	}

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

	public void setClientes(List<Cliente> clientes) {
		Clientes = clientes;
	}

	public void setProdutos(List<Produto> produtos) {
		Produtos = produtos;
	}

	public void setComandasAbertas(List<Comanda> comandasAbertas) {
		this.comandasAbertas = comandasAbertas;
	}

	public void setComandasEncerradas(List<Comanda> comandasEncerradas) {
		this.comandasEncerradas = comandasEncerradas;
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

	public ClienteRN getClienteRN() {
		return clienteRN;
	}

	public void setClienteRN(ClienteRN clienteRN) {
		this.clienteRN = clienteRN;
	}

	public ProdutoRN getProdutoRN() {
		return produtoRN;
	}

	public void setProdutoRN(ProdutoRN produtoRN) {
		this.produtoRN = produtoRN;
	}

	public ComandaRN getComandaRN() {
		return comandaRN;
	}

	public void setComandaRN(ComandaRN comandaRN) {
		this.comandaRN = comandaRN;
	}

	public ItemComandaRN getItemComandaRN() {
		return itemComandaRN;
	}

	public void setItemComandaRN(ItemComandaRN itemComandaRN) {
		this.itemComandaRN = itemComandaRN;
	}

}