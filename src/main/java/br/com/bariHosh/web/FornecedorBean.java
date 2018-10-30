package br.com.bariHosh.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.bariHosh.entidade.Endereco;
import br.com.bariHosh.entidade.EnumSexo;
import br.com.bariHosh.entidade.Fornecedor;
import br.com.bariHosh.entidade.Pessoa;
import br.com.bariHosh.negocio.FornecedorRN;


@ManagedBean(name = "fornecedorBean")
@RequestScoped
public class FornecedorBean {


	private Fornecedor fornecedor = new Fornecedor();
	private Pessoa pessoa = new Pessoa();
    private Endereco endereco = new Endereco();
	private List<Fornecedor> lista;
	private String destinoSalvar;
	private EnumSexo enumSexo;
	private FornecedorRN forneedoroRN;
	
	
	public FornecedorBean() {
		this.destinoSalvar = "fornecedores";
		this.forneedoroRN = new FornecedorRN();		
		this.pessoa = new Pessoa();
		this.fornecedor = new Fornecedor();
		this.endereco = new Endereco();
		this.pessoa.setEndereco(endereco);
		this.fornecedor.setPessoa(pessoa);
		this.fornecedor.setAtivo(true);	
		
	}


	public String novo() {		
		this.pessoa = new Pessoa();
		this.fornecedor = new Fornecedor();
		this.endereco = new Endereco();
		this.pessoa.setEndereco(endereco);
		this.fornecedor.setPessoa(pessoa);
		this.fornecedor.setAtivo(true);
		return "/restrito/fornecedor/fornecedor";
	}
	
	@PostConstruct
	public void init() {
		
		
	}

	public String editar() {		
		return "/restrito/fornecedor/fornecedor";
		
	}
	

	

	public String salvar() {		
		if(forneedoroRN.salvar(this.fornecedor)){
		    return this.destinoSalvar;			
		}
		   
		
		return null;
	}

	public String excluir() {		
		if(forneedoroRN.excluir(this.fornecedor)) {			
			this.lista = null;
			return null;
		}
	    return null;
		
	}

	public String ativar() {
		if (this.fornecedor.isAtivo())
			this.fornecedor.setAtivo(false);
		else
			this.fornecedor.setAtivo(true);	
		forneedoroRN.salvar(this.fornecedor);
		return null;
	}

	public List<Fornecedor> getLista() {
		if (this.lista == null) {			
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
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setLista(List<Fornecedor> lista) {
		this.lista = lista;
	}

	@SuppressWarnings("static-access")
	public EnumSexo[] getEnumSexo() {
		return enumSexo.values();
	}

	public void setEnumSexo(EnumSexo enumSexo) {
		this.enumSexo = enumSexo;
	}

}
