package br.com.bariHosh.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.bariHosh.entidade.CategoriaProduto;
import br.com.bariHosh.negocio.CategoriaProdutoRN;

@ManagedBean(name = "categoriaProdutoBean")
@RequestScoped
public class CategoriaProdutoBean {
	
	private CategoriaProduto categoria = new CategoriaProduto();
	private List<CategoriaProduto> lista;
	private String destinoSalvar;
	
	
	public String novo() {
		this.destinoSalvar = "categoriaProdutos";
		this.categoria = new CategoriaProduto();
		
		return "/restrito/categoriaProduto/categoriaProduto";
		
	}
	
	@PostConstruct
	public void init() {
		this.destinoSalvar = "categoriaProdutos";
		
	}
	
	public String salvar() {
		
		CategoriaProdutoRN categoriaRN = new CategoriaProdutoRN();
		categoriaRN.salvar(this.categoria);
		return this.destinoSalvar;
	}
	
	public String excluir() {
		
		CategoriaProdutoRN categoriaRN = new CategoriaProdutoRN();
		categoriaRN.excluir(this.categoria);
		this.lista=null;
		return null;
	}
	
	public String editar() {
		
		return "/restrito/categoriaProduto/categoriaProduto";
	}
	
	public List<CategoriaProduto> getLista(){
		
		if(this.lista==null) {
			CategoriaProdutoRN categoriaRN = new CategoriaProdutoRN();
			this.lista=categoriaRN.listar();
		}
		
		return this.lista;
	}
	

	public CategoriaProduto getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaProduto categoria) {
		this.categoria = categoria;
	}



	public void setLista(List<CategoriaProduto> lista) {
		this.lista = lista;
	}

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}
	
	

}
