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
	private CategoriaProduto categoriaFiltro = new CategoriaProduto();
	private List<CategoriaProduto> lista;
	private String destinoSalvar;
	private CategoriaProdutoRN categoriaRN = new CategoriaProdutoRN();
	
	public String novo() {
		this.destinoSalvar = "categoriaProdutos";
		this.categoria = new CategoriaProduto();
		
		return "/restrito/categoriaProduto/categoriaProduto";
		
	}
	
	@PostConstruct
	public void init() {
		this.categoriaRN = new CategoriaProdutoRN();
		this.destinoSalvar = "categoriaProdutos";
		
	}
	
	public String salvar() {	
		if(categoriaRN.salvar(this.categoria)) {
			return this.destinoSalvar;			
		}
		return null;
	}
	
	public String excluir() {		
		if(categoriaRN.excluir(this.categoria)) {			
			this.lista=null;
			return null;
		}	
		return null;
	}
	
	public String editar() {
		
		return "/restrito/categoriaProduto/categoriaProduto";
	}
	
	public List<CategoriaProduto> getLista(){		
		if(this.lista==null) {		
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
	
	public CategoriaProduto getCategoriaFiltro() {
		return categoriaFiltro;
	}

	public void setCategoriaFiltro(CategoriaProduto categoriaFiltro) {
		this.categoriaFiltro = categoriaFiltro;
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
	
	public String filtrar() {

		this.lista = categoriaRN.listaFiltrada(categoriaFiltro.getDescricao(), categoriaFiltro.getId_categoria());

		return "/restrito/categoriaProduto/categoriaProdutos";
	}
	
	

}
