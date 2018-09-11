package br.com.bariHosh.daoHibernate;

import java.util.List;

import org.hibernate.Session;

import br.com.bariHosh.dao.GenericDAO;
import br.com.bariHosh.entidade.Endereco;
import br.com.bariHosh.util.DAOFactory;

public class EnderecoDAOHibernate  implements GenericDAO<Endereco>{

	
    private Session session  = DAOFactory.PegarSession();     
	
	
	@Override
	public void salvar(Endereco model) {
		this.session.save(model);
		
	}

	@Override
	public void atualizar(Endereco model) {
		this.session.save(model);
		
	}

	@Override
	public void excluir(Endereco model) {
		this.session.delete(model);
		
	}

	@Override
	public Endereco carregar(Long id) {		
		return (Endereco) this.session.get(Endereco.class, id);
	}



	@Override
	public List<Endereco> listar() {
		return this.session.createCriteria(Endereco.class).list();
	}

	

}
