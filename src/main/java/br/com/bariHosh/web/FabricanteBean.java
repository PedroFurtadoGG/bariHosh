package br.com.bariHosh.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.bariHosh.entidade.Fabricante;
import br.com.bariHosh.negocio.FabricanteRN;

@ManagedBean(name = "fabricanteBean")
@RequestScoped
public class FabricanteBean {
	
	private Fabricante fabricante = new Fabricante();
	private List<Fabricante> lista ;
	private String destinoSalvar;
	private FabricanteRN fabRN = new FabricanteRN();
	
	private Fabricante fabricanteFiltro = new Fabricante();
	
	public FabricanteBean() {
		this.destinoSalvar = "fabricantes";
		this.fabricante = new Fabricante();
		this.fabricanteFiltro = new Fabricante();
	}
	
	public String novo() {
		this.destinoSalvar = "fabricantes";
		this.fabricante= new Fabricante();
		return "/restrito/fabricante/fabricante";
		
	}
	
	@PostConstruct
	public void init() {
		this.destinoSalvar= "fabricantes";
		
	}
	
	public String editar() {
		return "/restrito/fabricante/fabricante";
	}
	
	public String filtrar() {
		
		this.lista = fabRN.listaFiltrada(fabricanteFiltro.getCnpj(), fabricanteFiltro.getRazaoSocial());
		
		return "/restrito/fabricante/fabricantes";
	}
	
	public String salvar() {
		if (fabRN.salvar(this.fabricante)) {
			return this.destinoSalvar;
		}
		return null;
	}

	public String excluir() {	
		
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
	
	

	public Fabricante getFabricanteFiltro() {
		return fabricanteFiltro;
	}

	public void setFabricanteFiltro(Fabricante fabricanteFiltro) {
		this.fabricanteFiltro = fabricanteFiltro;
	}

	public List<Fabricante> getLista() {
		
		if(this.lista==null) {			
			this.lista=fabRN.listar();
		}
		return this.lista;
	}
	
}
