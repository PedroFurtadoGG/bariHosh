package br.com.bariHosh.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.bariHosh.entidade.Cliente;
import br.com.bariHosh.entidade.Comanda;
import br.com.bariHosh.entidade.EnumStatusComanda;
import br.com.bariHosh.entidade.ItemComanda;
import br.com.bariHosh.entidade.Pessoa;
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
	private Comanda comandaFiltro = new Comanda();
	private ItemComanda itemComanda = new ItemComanda();
	private String destinoSalvar;
	private ClienteRN clienteRN = new ClienteRN();
	private ProdutoRN produtoRN = new ProdutoRN();
	private ComandaRN comandaRN = new ComandaRN();
	private ItemComandaRN itemComandaRN = new ItemComandaRN();
	private Pessoa pessoaFiltro = new Pessoa();

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
		Comanda comanda = this.comandaRN.recuperaComandaParaEdicao("id_comanda_aberta");
		if (comanda != null) {
			this.comanda = comanda;
		}

		this.setPessoaFiltro(new Pessoa());
		this.comandaFiltro = new Comanda();

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
		if (new ComandaRN().retirarProdutoEmEstoque(this.itemComanda)) {
			this.itemComanda.setValorUnitario(this.itemComanda.getProduto().getValorSaida());
			this.itemComanda.setValorTotal(this.itemComanda.getProduto().getValorSaida() * this.itemComanda.getQuantidade());
			this.comanda.adicionaItemComanda(this.itemComanda);
			float valorItem = this.itemComanda.getValorTotal();
			this.comanda.setValorTotal(this.comanda.getValorTotal() + valorItem);
			this.itemComanda = new ItemComanda();
			ManuseioPublico.MessagesSucesso("Item adicionado com Sucesso !");

		}

	}

	public void excluirItemComanda() {
		if (new ComandaRN().devolverProdutoEstoque(this.itemComanda)) {
			this.comanda.removeItemComanda(this.itemComanda);			
			this.comanda.setValorTotal(this.comanda.getValorTotal() - this.itemComanda.getValorTotal());
			if (this.comanda.getId_comanda() != null) {	
				this.comanda.getItensDaComanda();
				new ItemComandaRN().excluirItemComanda(this.itemComanda);
				new ComandaRN().atualiza(this.comanda);
				this.comanda =  new ComandaRN().carregarComanda(this.comanda.getId_comanda());
				this.itemComanda = new ItemComanda();
				
			}
		}
	}

	public void excluirComanda(Comanda comanda) {
		this.comanda = comanda;
		if (new ComandaRN().excluir(this.comanda)) {
			this.comanda = new Comanda();
			this.comandasAbertas = null;
			this.comandasEncerradas = null;
		}

	}

	public String finalizarComanda(Comanda comanda) {
		this.comanda = comanda;
		this.destinoSalvar = "comandasAberto";
		this.comanda.setAtivo(false);
		if (new ComandaRN().finalizarComanda(this.comanda)) {
			this.comanda = new Comanda();
			this.comandasAbertas = null;
		}
		return this.destinoSalvar;
	}

	public String reativarComanda(Comanda comanda) {
		this.comanda = comanda;
		this.comanda.setAtivo(true);
		new ComandaRN().reativaComanda(comanda);
		this.comandasEncerradas = null;
		this.destinoSalvar = "comandasAberto";
		return this.destinoSalvar;

	}

	public String editarComanda(Comanda comanda) {
		this.comanda = comanda;
		this.destinoSalvar = "comanda";
		return this.destinoSalvar;

	}

	public String salvarComanda() {		
		this.comanda.setStatusComanda(EnumStatusComanda.EM_ABERTO);
		this.comanda.setAtivo(true);
		if (new ComandaRN().salvar(this.comanda)) {
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
			this.comandasEncerradas = new ComandaRN().listaComandasStatus(false);
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

	public Comanda getComandaFiltro() {
		return comandaFiltro;
	}

	public void setComandaFiltro(Comanda comandaFiltro) {
		this.comandaFiltro = comandaFiltro;
	}

	public String filtrarAbertas() {

		this.comandasAbertas = comandaRN.listaFiltrada(comandaFiltro.getId_comanda(),
				comandaFiltro.getCliente().getPessoa().getNome());

		return "/restrito/comanda/comandasAberto";
	}

	public Pessoa getPessoaFiltro() {
		return pessoaFiltro;
	}

	public void setPessoaFiltro(Pessoa pessoaFiltro) {
		this.pessoaFiltro = pessoaFiltro;
	}

}
