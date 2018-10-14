package br.com.bariHosh.daoHibernate;

import org.hibernate.Session;

import br.com.bariHosh.dao.SaldoEstoqueDAO;
import br.com.bariHosh.entidade.Produto;
import br.com.bariHosh.entidade.SaldoEstoque;
import br.com.bariHosh.util.DAOFactory;
 
public class SaldoEstoqueDAOHibernate  extends GenericoDAOHibernate<SaldoEstoque> implements SaldoEstoqueDAO{
	
      private Session session = DAOFactory.PegarSession();

	@Override
	public Integer pegaSaldoEstoque(Produto produto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void adicionaQuantidadeAoEStoque() {
		// TODO Auto-generated method stub
		
	} 

}
