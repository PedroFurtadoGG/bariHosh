package br.com.bariHosh.negocio;

import java.util.Date;
import java.util.List;

import br.com.bariHosh.daoHibernate.EstoqueDAOHibernate;
import br.com.bariHosh.daoHibernate.LogEstoqueDAOHibernate;
import br.com.bariHosh.daoHibernate.ProdutoDAOHibernate;
import br.com.bariHosh.entidade.EnumTipoRegistro;
import br.com.bariHosh.entidade.Estoque;
import br.com.bariHosh.entidade.Log_Estoque;
import br.com.bariHosh.entidade.Produto;
import br.com.bariHosh.entidade.Usuario;
import br.com.bariHosh.util.ManuseioPublico;

public class ProdutoRN extends ManuseioPublico {

	
	private ProdutoDAOHibernate produtoDAO;
	private EstoqueDAOHibernate estoqueDAO;
	private LogEstoqueDAOHibernate logDAO;
    private Log_Estoque logEstoque = new Log_Estoque(); 
    
    public ProdutoRN() {
		this.produtoDAO = new ProdutoDAOHibernate();
		this.logDAO= new LogEstoqueDAOHibernate();
		this.estoqueDAO =  new EstoqueDAOHibernate();
	}

	public Produto carregar(Long id) {
		return this.produtoDAO.carregar(Produto.class, id);
	}

	public boolean salvar(Produto produto) {
		try {
			if (super.CalcularDataValidadeProduto(produto.getEstoque().getData_validade_lote())) {
				Usuario usuarioLogado = super.buscarPorUsuarioLogado();
				if (super.validaObjeto(usuarioLogado.getId_usuario())) {
					//injetando id usuario
				   	produto.setId_usuario_criacao(usuarioLogado.getId_usuario());
				    //injetando saldo estoque 
					produto.getEstoque().setSaldoEstoque(produto.getEstoque().getQtd_produto()*produto.getValorEntrada());	
					
					// se id de produto estiver nulo  sera chamado este metodo 
					// que  e responsavel por criar um novo produto e seus atributos 
					if (!super.validaObjeto(produto.getId_produto())) {						
						
						// seta data criacao do produto e estoque 
						produto.setData_criacao(new Date());
						produto.getEstoque().setData_criacao(new Date());
						
						
						this.produtoDAO.salvar(produto);
						
						
						//cria log de estoque criando estoque 
						
					    this.logEstoque.setDt_movimentacao(new Date());
						this.logEstoque.setEstoque(produto.getEstoque());
						this.logEstoque.setUsuario_movimentador(usuarioLogado);
						this.logEstoque.setTipo_movimentacao(EnumTipoRegistro.ENTRADA);
						this.logEstoque.setDescricao("CRIACAO DE ESTOQUE PARA PRODUTO : "+"( "+produto.getId_produto()+" )");						
						this.logDAO.salvar(logEstoque);
						
						
						super.MessagesSucesso("Produto salvo com sucesso !");
						return true;
					} else {
						produto.setData_alteracao(new Date());
						this.produtoDAO.atualizar(produto);
						super.MessagesSucesso("Produto atualizado com sucesso !");
						return true;
					}

				} else {
					super.MessagesErro("E necessario Estar Logado!");

					return false;
				}
			} else {
				super.MessagesErro("Produto vencido !");
				return false;
			}

		} catch (Exception e) {
			System.out.println("erro ao salvar :" + e.getMessage());
			super.MessagesErro(
					"Ocorreu um erro na tentativa de salvar o Produto, verifique os campos obrigatrio e tente novamente.");
		}
		return false;
	}

	public boolean sxcluir(Produto produto) {
		try {
			if (super.validaObjeto(produto.getId_produto())) {
				this.produtoDAO.excluir(produto);
				super.MessagesSucesso("Produto deletado com sucesso !");
				return true;
			}
		} catch (Exception e) {
			System.out.println("erro ao excluir :" + e.getMessage());
			super.MessagesErro("Ocorreu um erro ao tentar excluir o Produto.");
		}
		return false;
	}
	
	public boolean excluir(Produto produto) {		
		try {
			if (super.validaObjeto(produto.getId_produto())) {
				List<Estoque> listaEstoque = this.estoqueDAO.ListaEstoqueVinculados(produto.getId_produto());						
						for(Estoque estoque :listaEstoque) {
							List<Log_Estoque> listalog = this.logDAO.ListaEtoqueVinculados(estoque.getId_estoque());
							for(Log_Estoque log: listalog) {
								this.logDAO.excluir(log);								
							}							
							this.estoqueDAO.excluir(estoque);
						}					
					
					this.produtoDAO.excluir(produto);
					super.MessagesSucesso("Produto deletado com sucesso !");
					return true;
				
			}
				
			}catch (Exception e) {
				System.out.println("erro ao excluir :" + e.getMessage());
				super.MessagesErro("Ocorreu um erro ao tentar excluir o Produto.");
			}
			return false;  
		
	}
	
	

	public List<Produto> listar() {
		return this.produtoDAO.listar(Produto.class);
	}
	
	public List<Produto> listarCompleto() {
		return this.produtoDAO.listaCompleta();
	}
	
	public List<Produto> listaFiltrada(String nome, Float valorEntrada, Float valorSaida, String codBarras){
		return this.produtoDAO.listaFiltrada(nome, valorEntrada, valorSaida, codBarras);
	}

	public Log_Estoque getLogEstoque() {
		return logEstoque;
	}

	public void setLogEstoque(Log_Estoque logEstoque) {
		this.logEstoque = logEstoque;
	}

	public LogEstoqueDAOHibernate getLogDAO() {
		return logDAO;
	}

	public void setLogDAO(LogEstoqueDAOHibernate logDAO) {
		this.logDAO = logDAO;
	}

	public EstoqueDAOHibernate getEstoqueDAO() {
		return estoqueDAO;
	}

	public void setEstoqueDAO(EstoqueDAOHibernate estoqueDAO) {
		this.estoqueDAO = estoqueDAO;
	}

	

	
	
}
