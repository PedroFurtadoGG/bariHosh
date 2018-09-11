package br.com.bariHosh.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.bariHosh.entidade.Fornecedor;
import br.com.bariHosh.negocio.FornecedorRN;


@ManagedBean(name = "fornecedorBean")
@RequestScoped
public class FornecedorBean {



	private Fornecedor fornecedor = new Fornecedor();

	private List<Fornecedor> lista;
	private String destinoSalvar;

	public String novo() {
		this.destinoSalvar = "fornecedorsucesso";
		this.fornecedor = new Fornecedor();
		this.fornecedor.setAtivo(true);
		return "/publico/fornecedor";
	}

	public String editar() {		
		return "/publico/fornecedor";
		
	}

	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();		

		FornecedorRN forneedoroRN = new FornecedorRN();
		forneedoroRN.salvar(this.fornecedor);
		return this.destinoSalvar;
	}

	public String excluir() {
		FornecedorRN forneedoroRN = new FornecedorRN();
		forneedoroRN.excluir(this.fornecedor);
		this.lista = null;
		return null;
	}

	public String ativar() {
		if (this.fornecedor.isAtivo())
			this.fornecedor.setAtivo(false);
		else
			this.fornecedor.setAtivo(true);

		FornecedorRN forneedoroRN = new FornecedorRN();
		forneedoroRN.salvar(this.fornecedor);
		return null;
	}

	public List<Fornecedor> getLista() {
		if (this.lista == null) {
			FornecedorRN forneedoroRN = new FornecedorRN();
			this.lista = forneedoroRN.listar();
		}
		return this.lista;
	}

	
	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

}
