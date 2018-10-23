package br.com.bariHosh.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.bariHosh.daoHibernate.CategoriaProdutoDAOHibernate;
import br.com.bariHosh.entidade.CategoriaProduto;

@FacesConverter("converterCategoriaProduto")
public class ConverterCategoriaProduto implements Converter {
	
	private CategoriaProdutoDAOHibernate dao = new CategoriaProdutoDAOHibernate();
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		if(value != null && !value.trim().equals("")) {
			
			CategoriaProduto categoria = new CategoriaProduto();
			Long id = Long.parseLong(value);
			
			categoria= dao.carregar(CategoriaProduto.class, id );
			
			return categoria;
		}else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(value==null || value.equals("")) {
			
			return "";
			
		}else {
			
			return String.valueOf(((CategoriaProduto)value).getId_categoria());
		}
		
	}

}
