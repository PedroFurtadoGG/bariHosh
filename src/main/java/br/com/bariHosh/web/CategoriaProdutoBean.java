package br.com.bariHosh.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.bariHosh.entidade.CategoriaProduto;
import br.com.bariHosh.negocio.CategoriaProdutoRN;

@ManagedBean(name = "categoriaProdutoBean")
@RequestScoped
public class CategoriaProdutoBean {
	
	private CategoriaProduto categoria = new CategoriaProduto();
	private CategoriaProdutoRN categoriaRN = new CategoriaProdutoRN();
	private List<CategoriaProduto> lista;
	private String destinoSalvar;
	
	
	public CategoriaProdutoBean() {
		this.destinoSalvar = "categoriaProdutos";
		this.categoria =new CategoriaProduto();
	}
	
	public String novo() {
		this.destinoSalvar = "categoriaProdutos";
		this.categoria = new CategoriaProduto();
		
		return "/restrito/categoriaProduto/categoriaProduto";
		
	}
	
	public String salvar() {		
		if(categoriaRN.salvar(this.categoria)){			
			return this.destinoSalvar;			
		}
		return null;
	}
	
	public String excluir() {		
		categoriaRN.excluir(this.categoria);
		this.lista=null;
		return null;
	}
	
	public String editar() {
		
		return "/restrito/categoriaProduto/categoriaProduto";
	}

	public CategoriaProduto getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaProduto categoria) {
		this.categoria = categoria;
	}

	public CategoriaProdutoRN getCategoriaRN() {
		return categoriaRN;
	}

	public void setCategoriaRN(CategoriaProdutoRN categoriaRN) {
		this.categoriaRN = categoriaRN;
	}

	public List<CategoriaProduto> getLista() {
		if(this.lista==null) {
			this.lista=categoriaRN.listar();
		}
		
		return this.lista;
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
