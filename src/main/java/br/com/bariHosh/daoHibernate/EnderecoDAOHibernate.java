package br.com.bariHosh.daoHibernate;

import java.util.List;

import br.com.bariHosh.dao.EnderecoDAO;
import br.com.bariHosh.entidade.Endereco;

public class EnderecoDAOHibernate extends GenericoDAOHibernate<Endereco> implements EnderecoDAO {

	@Override
	public Endereco pegaEnderecoPeloCodPessoa(Long id) {		
		return super.carregar(Endereco.class, id);
	}

	@Override
	public List<Endereco> listaEnderecoPorBairro(String bairro) {
		
		return null;
	}

}
