package br.com.bariHosh.negocio;

import java.util.List;

import javax.faces.context.FacesContext;

import br.com.bariHosh.daoHibernate.ComandaDAOHibernate;
import br.com.bariHosh.entidade.Comanda;
import br.com.bariHosh.util.ManuseioPublico;


public class ComandaRN  extends ManuseioPublico{
	
	private ComandaDAOHibernate comandaDAO  = new ComandaDAOHibernate();
	
	
	
	public boolean salvar(Comanda comanda) {
		try {
			if(!super.validaObjeto(comanda.getId_comanda())) {			
				this.comandaDAO.salvar(comanda);
				super.MessagesSucesso("Comanda Salva Com Sucesso ");
				return true;
			}else{
				super.MessagesSucesso("Comanda Atualizada  Com Sucesso ");
				this.comandaDAO.atualizar(comanda);
				return true;
				
			}	
		}catch (Exception e) {
			System.out.println("erro excluir" + e.getMessage());
			super.MessagesErro("Ouve erro na tentativa de salvar a comanda contate Administrador do sistema!");
		}
		return false;
		
	}
	
public boolean excluir(Comanda comanda) {
		try {
		if(super.validaObjeto(comanda.getId_comanda())) {			
			this.comandaDAO.excluir(comanda);
			super.MessagesSucesso("Comanda Excluido Com Sucesso!");
			return true;
		}		
		}catch (Exception e) {
			System.out.println("erro excluir" + e.getMessage());
			super.MessagesErro("Ouve erro na tentativa de excluir a comanda contate Administrador do sistema!");
	  	return false;
		}
		return false;
	}



	public ComandaDAOHibernate getComandaDAO() {
		return comandaDAO;
	}



	public void setComandaDAO(ComandaDAOHibernate comandaDAO) {
		this.comandaDAO = comandaDAO;
	}



	public List<Comanda> listaComandasStatus(boolean status) {		 
		return this.comandaDAO.listaComandasStatus(status);
	}
	
	public  Comanda  recuperaComandaParaEdicao() { 	       
         String idcomanda = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id_comanda");
	    if(super.validaObjeto(idcomanda)) {
	    	 return  this.comandaDAO.carregar(Comanda.class, Long.parseLong(idcomanda));
	    }
       return null;
	}



	



	
	
	

}
