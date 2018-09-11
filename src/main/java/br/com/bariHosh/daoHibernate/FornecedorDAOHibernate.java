package br.com.bariHosh.daoHibernate;

import java.util.List;

import org.hibernate.Session;

import br.com.bariHosh.dao.GenericDAO;
import br.com.bariHosh.entidade.Fornecedor;
import br.com.bariHosh.util.DAOFactory;

public class FornecedorDAOHibernate implements GenericDAO<Fornecedor> {

	private Session session  = DAOFactory.PegarSession();
	
	
	@Override
	public void salvar(Fornecedor model) {
		this.session.save(model);
		
	}

	@Override
	public void atualizar(Fornecedor model) {
		this.session.save(model);
		
	}

	@Override
	public void excluir(Fornecedor model) {
		this.session.delete(model);
		
	}

	@Override
	public Fornecedor carregar(Long id) {		
		return (Fornecedor) this.session.get(Fornecedor.class,id);
	}

	

	@Override
	public List<Fornecedor> listar() {		
		return this.session.createCriteria(Fornecedor.class ).list();
	}

	

	

}
