package br.com.bariHosh.negocio;

import java.util.List;
import br.com.bariHosh.daoHibernate.FabricanteDAOHibernate;
import br.com.bariHosh.entidade.Fabricante;
import br.com.bariHosh.util.ManuseioPublico;

public class FabricanteRN extends ManuseioPublico{
	

	private FabricanteDAOHibernate fabricanteDAO;
	
	public FabricanteRN(){
	
		this.fabricanteDAO = new FabricanteDAOHibernate();
	}
	
	public boolean salvar(Fabricante fab) {		
		try {
			if(!super.validaObjeto(fab.getId_fabricante())) {
				this.fabricanteDAO.salvar(fab);
				super.MessagesSucesso("Fabricante Salvo Com Sucesso!");
				return true;
			}else {
				this.fabricanteDAO.atualizar(fab);
				super.MessagesSucesso("Fabricante Atualizado Com Sucesso!");
				return true;
			}		

		} catch (Exception e) {
			System.out.println("erro salvar" + e.getMessage());
			super.MessagesErro(
					"Ouve erro na tentativa de salvar o fabricante Verifique os campos Obrigatorios e tente novamente!");

		}
		return false;

	}
	
	public Fabricante carregar(Long id) {
		return this.fabricanteDAO.carregar(Fabricante.class,id);
	}
	
	public void excluir(Fabricante fab) {		
		
		try {
			if (super.validaObjeto(fab.getId_fabricante())) {
				this.fabricanteDAO.excluir(fab);
				super.MessagesSucesso("Fabricante  Excluido Com Sucesso!");
			}

		} catch (Exception e) {
			System.out.println("erro excluir" + e.getMessage());
			super.MessagesErro("Ouve erro na tentativa de excluir o fabricante contate Administrador do sistema!");
		}
		
	}
	
	public List<Fabricante> listar(){
		return this.fabricanteDAO.listar(Fabricante.class);
	}
	
	public List<Fabricante> listaFiltrada(String cnpj, String razaoSocial){
		return this.fabricanteDAO.listaFiltrada(cnpj, razaoSocial);
		
	}

}
