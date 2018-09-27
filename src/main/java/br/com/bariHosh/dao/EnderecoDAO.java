package br.com.bariHosh.dao;

import java.util.List;

import br.com.bariHosh.entidade.Endereco;

public interface EnderecoDAO {
	
	public Endereco pegaEnderecoPeloCodPessoa(Long id);
	public List<Endereco> listaEnderecoPorBairro(String bairro);

}
