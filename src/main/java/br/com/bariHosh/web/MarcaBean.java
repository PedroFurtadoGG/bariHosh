package br.com.bariHosh.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.bariHosh.entidade.Fabricante;
import br.com.bariHosh.entidade.Marca;
import br.com.bariHosh.negocio.MarcaRN;

@ManagedBean(name = "marcaBean")
@RequestScoped
public class MarcaBean {
	
	private Marca marca = new Marca();
	private Fabricante fabricante = new Fabricante();
	private List<Marca> lista;
	private String destinoSalvar;
	
	public String novo() {
		this.destinoSalvar = "marcaSucesso";
		this.marca = new Marca();
		this.setFabricante(new Fabricante());
		return "/publico/marca";		
	}
	
	@PostConstruct
	public void init() {
		this.destinoSalvar = "marcas";
		this.setFabricante(new Fabricante());
		this.marca = new Marca();
		this.marca.setFabricante(fabricante);
		
	}
	
	public String editar() {
		return "/publico/marca";
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
