package br.com.bariHosh.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.bariHosh.entidade.Fabricante;
import br.com.bariHosh.entidade.Fornecedor;
import br.com.bariHosh.entidade.Marca;
import br.com.bariHosh.negocio.FabricanteRN;
import br.com.bariHosh.negocio.FornecedorRN;
import br.com.bariHosh.negocio.MarcaRN;

@ManagedBean(name = "marcaBean")
@RequestScoped
public class MarcaBean {
	
	private Marca marca = new Marca();
	private Fabricante fabricante = new Fabricante();
	private List<Marca> lista;
	private String destinoSalvar;
	private List<Fabricante> listaFab;
	private MarcaRN marcaRN = new MarcaRN();
	private List<Fornecedor> listaForn;
	private Fornecedor fornecedor = new Fornecedor();


	public MarcaBean() {
		
		this.fornecedor= new Fornecedor();
		this.fabricante = new Fabricante();
		this.marca.setFabricante(fabricante);
	}

	public String novo() {
		this.destinoSalvar = "marcas";
		this.fabricante = new Fabricante();
		this.fornecedor = new Fornecedor();
		this.marca = new Marca();
		this.marca.setFabricante(fabricante);
		this.marca.setFornecedor(fornecedor);
		return "/restrito/marca/marca";		
	}
	
	@PostConstruct
	public void init() {
		this.destinoSalvar="marcas";
		this.setFabricante(new Fabricante());
		this.setFornecedor(new Fornecedor());
		this.marca = new Marca();
		this.marca.setFabricante(fabricante);
		this.marca.setFornecedor(fornecedor);
	}
	
	
	public String editar() {
		this.marca.getFabricante();
		this.marca.getFornecedor();
		return "/restrito/marca/marca";
	}
	
	public String salvar() {

		marcaRN.salvar(this.marca);

		return this.destinoSalvar;
	}

	public String excluir() {
		
	
		marcaRN.excluir(this.marca);
		this.lista = null;
		return null;
	}
	
	public List<Marca> getLista(){		
		if(this.lista == null) {			
			this.lista = marcaRN.listar();
		}
		return this.lista;
	}
	
	public  void setLista(List<Marca> lista){
		this.lista = lista;
		
	}
	
	
	

	public List<Fabricante> getListaFab() {
		
		if(this.listaFab==null) {
			FabricanteRN fabRN = new FabricanteRN();
			this.listaFab = fabRN.listar();
		}
		return this.listaFab;
	}

	public void setListaFab(List<Fabricante> listaFab) {
		this.listaFab = listaFab;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

	public List<Fornecedor> getListaForn() {
		
		if(this.listaForn ==null) {
			FornecedorRN fornRN = new FornecedorRN();
			this.listaForn= fornRN.listar();
		}
		
		return listaForn;
	}

	public void setListaForn(List<Fornecedor> listaForn) {
		this.listaForn = listaForn;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	


}
