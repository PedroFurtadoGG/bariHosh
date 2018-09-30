package br.com.bariHosh.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.bariHosh.entidade.Fabricante;
import br.com.bariHosh.entidade.Marca;
import br.com.bariHosh.negocio.FabricanteRN;
import br.com.bariHosh.negocio.MarcaRN;

@ManagedBean(name = "marcaBean")
@RequestScoped
public class MarcaBean {
	
	private Marca marca = new Marca();
	private Fabricante fabricante = new Fabricante();
	private List<Marca> lista;
	private String destinoSalvar;
	private List<Fabricante> listaFab;
	


	public MarcaBean() {
		
		this.fabricante = new Fabricante();
		this.marca.setFabricante(fabricante);
	}

	public String novo() {
		this.destinoSalvar = "marcaSucesso";
		this.fabricante = new Fabricante();
		this.marca = new Marca();
		this.marca.setFabricante(fabricante);
		return "/publico/marca/marca";		
	}
	
	@PostConstruct
	public void init() {
		this.destinoSalvar="marcas";
		this.setFabricante(new Fabricante());
		this.marca = new Marca();
		this.marca.setFabricante(fabricante);
	}
	
	
	public String editar() {
		return "/publico/marca/marca";
	}
	
	public String  salvar() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		 MarcaRN marcaRN = new MarcaRN();
		 this.marca.setFabricante(fabricante);
		 marcaRN.salvar(this.marca);
		 
		return this.destinoSalvar;
	}
	
	public String excluir() {
		
		MarcaRN marcaRN = new MarcaRN();
		marcaRN.excluir(this.marca);
		this.lista = null;
		return null;
	}
	
	public List<Marca> getLista(){
		
		if(this.lista == null) {
			MarcaRN marcaRN = new MarcaRN();
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


}