package br.com.bariHosh.ordenadores;

import java.util.List;

import br.com.bariHosh.entidade.Comanda;
import br.com.bariHosh.util.OrdenadorTemplateMethod;

public class OrdenadorComanda  extends OrdenadorTemplateMethod<Comanda>{

	
	
	public OrdenadorComanda(List<Comanda> array) {
		super(array);
		
	}

	@Override
	public boolean ePrimeiro(Comanda obj, Comanda obj1) {
		   if(obj.getId_comanda()<= obj1.getId_comanda())return true ; 
	       else return false ;
	}

	

}
