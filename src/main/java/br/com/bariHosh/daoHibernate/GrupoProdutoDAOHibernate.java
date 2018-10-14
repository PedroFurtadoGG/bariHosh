package br.com.bariHosh.daoHibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import br.com.bariHosh.dao.GrupoProdutoDAO;
import br.com.bariHosh.entidade.GrupoProduto;
import br.com.bariHosh.entidade.Produto;
import br.com.bariHosh.util.DAOFactory;

public class GrupoProdutoDAOHibernate  extends GenericoDAOHibernate<GrupoProduto> implements GrupoProdutoDAO{
	
	private Session session = DAOFactory.PegarSession();

	@Override
	public List<Produto> listaProdutoPorGrupo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer pegaQtdProduto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GrupoProduto pegaGrupoPeloProduto(Produto produto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> listaProdutoValidade(Date data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void adicionaProdutoAoGrupo(Produto produto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void retiraProdutoDoGrupo(Produto produto) {
		// TODO Auto-generated method stub
		
	}

}
