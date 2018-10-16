package br.com.bariHosh.negocio;

import java.util.List;

import br.com.bariHosh.daoHibernate.MarcaDAOHibernate;
import br.com.bariHosh.entidade.Marca;
import br.com.bariHosh.util.ManuseioPublico;

public class MarcaRN extends ManuseioPublico {

	private MarcaDAOHibernate marcaDAO;

	public MarcaRN() {

		this.marcaDAO = new MarcaDAOHibernate();

	}

	public Marca carregar(Long id) {
		return this.marcaDAO.carregar(Marca.class, id);
	}

	public boolean salvar(Marca marca) {
		try {
			if (!super.validaObjeto(marca.getId_marca())) {
				this.marcaDAO.salvar(marca);
				super.MessagesSucesso("Marca Salvo Com Sucesso!");
				return true;
			
			} else {
				this.marcaDAO.atualizar(marca);
				super.MessagesSucesso("Marca Salvo Com Sucesso!");
				return true;
				
			}
			
		} catch (Exception e) {
			System.out.println("erro salvar" + e.getMessage());
			super.MessagesErro(
					"Houve erro na tentativa de salvar o Marca Verifique os campos Obrigatorios e tente novamente!");
		}

		return false;
	}

	public void excluir(Marca marca) {
		try {
			if (super.validaObjeto(marca.getId_marca())) {				
				this.marcaDAO.excluir(marca);				
				super.MessagesSucesso("Marca Excluido Com Sucesso!");
			}

		} catch (Exception e) {
			System.out.println("erro excluir" + e.getMessage());
			super.MessagesErro("Ouve erro na tentativa de excluir a marca  contate Administrador do sistema!");
		}

	
	}

	public List<Marca> listar() {
		return this.marcaDAO.listar(Marca.class);
	}

}
