package br.com.bariHosh.negocio;

import java.util.Date;
import java.util.List;

import br.com.bariHosh.daoHibernate.EstoqueDAOHibernate;
import br.com.bariHosh.daoHibernate.ProdutoDAOHibernate;
import br.com.bariHosh.entidade.Estoque;
import br.com.bariHosh.entidade.Log_Estoque;
import br.com.bariHosh.entidade.Produto;
import br.com.bariHosh.entidade.Usuario;
import br.com.bariHosh.util.ManuseioPublico;

public class EstoqueRN extends ManuseioPublico{
	
	private EstoqueDAOHibernate estoqueDAO ;
	private ProdutoDAOHibernate  produtoDAO;
	private Log_Estoque logSistema ;

	
	public EstoqueRN() {
		this.estoqueDAO =new EstoqueDAOHibernate();	
		this.logSistema  =  new Log_Estoque();
		 this.produtoDAO = new ProdutoDAOHibernate()  ;
	} 

	public boolean salvar(Estoque estoque){
		try {
			Usuario usuarioLogado = super.buscarPorUsuarioLogado();				
			logSistema.setUsuario_movimentador(usuarioLogado);
			logSistema.setDt_movimentacao(new Date());
			logSistema.setEstoque(estoque);
		 	estoque.getMovimentacao().add(logSistema);		
			if (!super.validaObjeto(usuarioLogado)) {
				if (!super.validaObjeto(estoque.getId_estoque())) {	
					logSistema.setTipo_movimentacao("Criaçao do Estoque");
					this.estoqueDAO.salvar(estoque);
				} else {				
					this.estoqueDAO.atualizar(estoque);
				}
				super.MessagesSucesso("Estoque Salvo Com Sucesso !");
				return true;
			} else {
				super.MessagesErro("E necessario Estar Logado!");
				return false;
			}

		} catch (Exception e) {
			System.out.println("erro salvar" + e.getMessage());
			super.MessagesErro(
					"Ouve erro na tentativa de salvar o estoque Verifique os campos Obrigatorios e tente novamente!");

		}
		return false;

	}
	public void excluir(Estoque estoque){
		
		try {
			if (super.validaObjeto(estoque.getId_estoque())) {
				this.estoqueDAO.excluir(estoque);
				 super.MessagesSucesso("Estoque Excluido Com Sucesso!");
			}

		} catch (Exception e) {
			System.out.println("erro excluir" + e.getMessage());
			super.MessagesErro("Ouve erro na tentativa de excluir o estoque contate Administrador do sistema!");
		}
		
	}
	
	public List<Estoque> listar() {
		return this.estoqueDAO.listar(Estoque.class);
	}


	public boolean diminuirEstoqueProduto(Estoque estoque,Integer quantiaRemove) {
		logSistema = new Log_Estoque();
		
		    Integer qtdEstoque  = estoque.getQtd_produto();
		    if(qtdEstoque < quantiaRemove) {
		    	super.MessagesErro("Quantia de Retira Ultrapassa o limite de estoque !");
		    	return false ;
		    }else {
		    	qtdEstoque = qtdEstoque - quantiaRemove;
		    	estoque.setQtd_produto(qtdEstoque);
		    	logSistema.setTipo_movimentacao("Retirada do Estoque");
		    	super.MessagesSucesso("Prouduto Retidado OK !");
		    	this.salvar(estoque);
		    }
		return false;
	}

	public boolean aumentarEstoqueProduto(Estoque estoque, Integer quantiaAdd) {	
		logSistema = new Log_Estoque();		
		        Integer qtdEstoque  = estoque.getQtd_produto();
		    if( quantiaAdd<=0) {
		    	super.MessagesErro("Quantia de Adição nao reproduz efeito no estoque  !");
		    	return false ;
		    }else {
		    	qtdEstoque = qtdEstoque + quantiaAdd;
		    	estoque.setQtd_produto(qtdEstoque);
		    	logSistema.setTipo_movimentacao("Inclusão no Estoque");
		    	this.salvar(estoque);
		    	super.MessagesSucesso("Prouduto Adicionado OK !");
		    	return true ;
		    }
		
	}

	public Integer obterTotalProdutosEmEstoqueGeral() {
	       List<Produto> listaProduto =  produtoDAO.listar(Produto.class);
	       Integer qtdTOTAL =0 ;
	       for(Produto produto : listaProduto) {
	    	   qtdTOTAL = qtdTOTAL + produto.getEstoque().getQtd_produto();	    	   
	       }
	      
		return qtdTOTAL;
	}

	public EstoqueDAOHibernate getEstoqueDAO() {
		return estoqueDAO;
	}

	public void setEstoqueDAO(EstoqueDAOHibernate estoqueDAO) {
		this.estoqueDAO = estoqueDAO;
	}
	
	

}
