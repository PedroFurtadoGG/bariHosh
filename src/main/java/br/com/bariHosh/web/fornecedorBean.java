package br.com.bariHosh.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.bariHosh.entidade.Endereco;
import br.com.bariHosh.entidade.Fornecedor;
import br.com.bariHosh.entidade.Pessoa;
import br.com.bariHosh.negocio.FornecedorRN;


@ManagedBean(name = "fornecedorBean")
@RequestScoped
public class fornecedorBean {



	private Fornecedor fornecedor = new Fornecedor();
	private Pessoa pessoa = new Pessoa();
    private Endereco endereco = new Endereco();
	private List<Fornecedor> lista;
	private String destinoSalvar;

	public String novo() {
		this.destinoSalvar = "fornecedorsucesso";
		this.setPessoa(new Pessoa());
		this.fornecedor = new Fornecedor();
		this.endereco = new Endereco();
		this.pessoa.setEndereco(endereco);
		this.fornecedor.setPessoa(pessoa);
		this.fornecedor.setAtivo(true);
		return "/publico/fornecedor";
	}
	
	@PostConstruct
	public void init() {
		this.destinoSalvar = "fornecedores";
		this.setPessoa(new Pessoa());
		this.fornecedor = new Fornecedor();
		this.endereco = new Endereco();
		this.pessoa.setEndereco(endereco);
		this.fornecedor.setPessoa(pessoa);
		this.fornecedor.setAtivo(true);
		
	}

	public String editar() {		
		return "/publico/fornecedor";
		
	}
	

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setLista(List<Fornecedor> lista) {
		this.lista = lista;
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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

}
