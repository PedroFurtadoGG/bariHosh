package br.com.bariHosh.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.bariHosh.entidade.Fabricante;
import br.com.bariHosh.negocio.FabricanteRN;

@ManagedBean(name="fabricanteBean")
@RequestScoped
public class FabricanteBean {
	
	private Fabricante fab = new Fabricante();
	private List<Fabricante> lista ;
	private String destinoSalvar;
	
	public String novo() {
		this.destinoSalvar = "fabricante";
		this.fab= new Fabricante();
		return "/publico/fabricante";
		
	}
	
	@PostConstruct
	public void init() {
		this.destinoSalvar= "fabricantes";
		this.fab = new Fabricante();
		
	}
	
	public String editar() {
		return "/public/fabricante";
	}
	
	public String salvar() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		FabricanteRN fabRN = new FabricanteRN();
		fabRN.salvar(this.fab);
		return this.destinoSalvar;
	}
	
	public String excluir() {
		
		FabricanteRN fabRN = new FabricanteRN();
		fabRN.excluir(this.fab);
		this.lista = null;
		return null;
		
	}

	public Fabricante getFab() {
		return fab;
	}

	public void setFab(Fabricante fab) {
		this.fab = fab;
	}
	
	
	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

	public List<Fabricante> getLista() {
		
		if(this.lista==null) {
			FabricanteRN fabRN = new FabricanteRN();
			this.lista=fabRN.listar();
		}
		return this.lista;
	}
	
}
