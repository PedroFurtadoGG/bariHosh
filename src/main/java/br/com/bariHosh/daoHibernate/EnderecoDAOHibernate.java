package br.com.bariHosh.daoHibernate;

import java.util.List;

import org.hibernate.Session;

import br.com.bariHosh.dao.EnderecoDAO;
import br.com.bariHosh.entidade.Endereco;
import br.com.bariHosh.util.DAOFactory;

public class EnderecoDAOHibernate extends GenericoDAOHibernate<Endereco> implements EnderecoDAO {

	private Session session = DAOFactory.PegarSession();

	@Override
	public Endereco pegaEnderecoPeloCodPessoa(Long id) {
		
		return null;
	}

	@Override
	public List<Endereco> listaEnderecoPorBairro(String bairro) {
		
		return null;
	}

}
