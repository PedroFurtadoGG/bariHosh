package br.com.bariHosh.negocio;

import java.util.List;
import java.util.Objects;

import br.com.bariHosh.daoHibernate.MarcaDAOHibernate;
import br.com.bariHosh.entidade.Marca;

public class MarcaRN {

	private MarcaDAOHibernate marcaDAO;

	public MarcaRN() {

		this.marcaDAO = new MarcaDAOHibernate();

	}

	public Marca carregar(Long id) {
		return this.marcaDAO.carregar(Marca.class, id);
	}

	public void salvar(Marca marca) {
		if (Objects.isNull(marca.getId_marca())) {

			this.marcaDAO.salvar(marca);

		} else {

			this.marcaDAO.atualizar(marca);
		}

	}

	public void excluir(Marca marca) {
		this.marcaDAO.excluir(marca);
	}

	public List<Marca> listar() {
		return this.marcaDAO.listar(Marca.class);
	}

}
