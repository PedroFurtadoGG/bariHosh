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
	
	private Fabricante fabricante = new Fabricante();
	private List<Fabricante> lista ;
	private String destinoSalvar;
	
	public String novo() {
		this.destinoSalvar = "fabricante";
		this.fabricante= new Fabricante();
		return "/restrito/fabricante";
		
	}
	
	@PostConstruct
	public void init() {
		this.destinoSalvar= "fabricantes";
		
	}
	
	public String editar() {
		return "/restrito/fabricante/fabricante";
	}
	
	public String salvar() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		FabricanteRN fabRN = new FabricanteRN();
		fabRN.salvar(this.fabricante);
		return this.destinoSalvar;
	}
	
	public String excluir() {
		
		FabricanteRN fabRN = new FabricanteRN();
		fabRN.excluir(this.fabricante);
		this.lista = null;
		return null;
		
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

	public List<Fabricante> getLista() {
		
		if(this.lista==null) {
			FabricanteRN fabRN = new FabricanteRN();
			this.lista=fabRN.listar();
		}
		return this.lista;
	}
	
}
