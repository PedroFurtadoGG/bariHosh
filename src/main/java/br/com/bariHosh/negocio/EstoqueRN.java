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

public class EstoqueRN extends ManuseioPublico {

	private EstoqueDAOHibernate estoqueDAO;
	private ProdutoDAOHibernate produtoDAO;
	private LogEstoqueDAOHibernate logDAO;

	public EstoqueRN() {
		this.estoqueDAO = new EstoqueDAOHibernate();
		this.setLogDAO(new LogEstoqueDAOHibernate());
		this.produtoDAO = new ProdutoDAOHibernate();
	}
	
	public Estoque carregarEstoque(Long idEstoque) {		
		return this.estoqueDAO.carregar(Estoque.class,idEstoque);
	}
	public Estoque carregarEstoquePorProduto(Produto produto) {
		return this.estoqueDAO.pegaEstoquePeloProduto(produto);
	}

	public boolean salvar(Produto produto, Log_Estoque logEstoque, Integer lancamentoQuantia) {
		try {
			if (super.CalcularDataValidadeProduto(produto.getEstoque().getData_validade_lote())) {
				Usuario usuarioLogado = super.buscarPorUsuarioLogado();
				if (super.validaObjeto(usuarioLogado)) {
					if (logEstoque.getTipo_movimentacao() == EnumTipoRegistro.ENTRADA) {

						// finalizacao estoque ao produto criacao de novo estoque injetando ao produto
						produto.getEstoque().setAtivo(false);
						produto.getEstoque().setData_finalizacao(new Date());
						estoqueDAO.atualizar(produto.getEstoque());

						Estoque estoque = new Estoque();
						estoque.setAtivo(true);
						estoque.setData_criacao(new Date());
						estoque.setQtd_produto(produto.getEstoque().getQtd_produto());
						estoque.setData_validade_lote(produto.getEstoque().getData_validade_lote());
						estoque.setSaldoEstoque(produto.getEstoque().getSaldoEstoque());
						estoque.setProduto(produto);
						produto.setEstoque(estoque);

						if (aumentarEstoqueProduto(produto.getEstoque(), lancamentoQuantia)) {
							logEstoque = new Log_Estoque();
							logEstoque.setTipo_movimentacao(EnumTipoRegistro.ENTRADA);
							logEstoque.setUsuario_movimentador(usuarioLogado);
							logEstoque.setDt_movimentacao(new Date());
							logEstoque.setEstoque(produto.getEstoque());
							logEstoque.setDescricao(
									"CRIACAO DE ESTOQUE PARA PRODUTO : " + "( " + produto.getId_produto() + " )");
							logDAO.salvar(logEstoque);
							return true;

						}
						return false;

					} else if (logEstoque.getTipo_movimentacao() == EnumTipoRegistro.SAIDA) {

						if (diminuirEstoqueProduto(produto.getEstoque(), lancamentoQuantia)) {
							logEstoque = new Log_Estoque();
							logEstoque.setTipo_movimentacao(EnumTipoRegistro.SAIDA);
							logEstoque.setUsuario_movimentador(usuarioLogado);
							logEstoque.setDt_movimentacao(new Date());
							logEstoque.setEstoque(produto.getEstoque());
							logEstoque.setDescricao(
									"ALTERACAO DE ESTOQUE PARA PRODUTO : " + "( " + produto.getId_produto() + " )");
							logDAO.salvar(logEstoque);
							return true;

						}
						return false;

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
			System.out.println("erro salvar" + e.getMessage());
			super.MessagesErro(
					"Ouve erro na tentativa de salvar o estoque Verifique os campos Obrigatorios e tente novamente!");

		}
		return false;

	}

	public void excluir(Estoque estoque) {

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

	public boolean diminuirEstoqueProduto(Estoque estoque, Integer quantiaRemove) {
		try {
			Integer qtdEstoque = estoque.getQtd_produto();
			if (qtdEstoque < quantiaRemove) {
				super.MessagesErro("Quantia de Retira Ultrapassa o limite de estoque !");
				return false;
			} else {
				qtdEstoque = qtdEstoque - quantiaRemove;
				estoque.setQtd_produto(qtdEstoque);
				estoque.setSaldoEstoque(estoque.getProduto().getValorEntrada()*qtdEstoque);
				new EstoqueDAOHibernate().atualizar(estoque);
				return true;
			}
		} catch (Exception e) {
			super.MessagesErro("erro "+e.getMessage() );
			return false;
		}
	}

	public boolean aumentarEstoqueProduto(Estoque estoque, Integer quantiaAdd) {		
			Integer qtdEstoque = estoque.getQtd_produto();			
			if (quantiaAdd <= 0) {
				super.MessagesErro("Quantia de Adi��o nao reproduz efeito no estoque  !");
				return false;
			} else {
				
				qtdEstoque = qtdEstoque + quantiaAdd;
				estoque.setQtd_produto(qtdEstoque);
				estoque.setSaldoEstoque(estoque.getProduto().getValorEntrada()*qtdEstoque);
				new EstoqueDAOHibernate().atualizar(estoque);
				return true;
			}
		

	}
	

	public Integer obterTotalProdutosEmEstoqueGeral() {
		List<Produto> listaProduto = produtoDAO.listar(Produto.class);
		Integer qtdTOTAL = 0;
		for (Produto produto : listaProduto) {
			qtdTOTAL = qtdTOTAL + produto.getEstoque().getQtd_produto();
		}

		return qtdTOTAL;
	}

	public boolean VerificaEstoque(Estoque estoque, Integer quantidade) {
		Estoque estoqueaux = this.estoqueDAO.carregar(Estoque.class, estoque.getId_estoque());
		if (estoqueaux.getQtd_produto() >= quantidade) {
			return true;
		}
		super.MessagesErro("N�o existe estoque para o " + estoque.getProduto().getNome());
		return false;
	}

	public EstoqueDAOHibernate getEstoqueDAO() {
		return estoqueDAO;
	}

	public void setEstoqueDAO(EstoqueDAOHibernate estoqueDAO) {
		this.estoqueDAO = estoqueDAO;
	}

	public LogEstoqueDAOHibernate getLogDAO() {
		return logDAO;
	}

	public void setLogDAO(LogEstoqueDAOHibernate logDAO) {
		this.logDAO = logDAO;
	}
	
	public List<Estoque> listaFiltrada(Long id_produto, String nome,String barras){
		return this.estoqueDAO.listaFiltrada(id_produto, nome, barras);
	}

	

}
