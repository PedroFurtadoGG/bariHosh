package br.com.bariHosh.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.bariHosh.daoHibernate.MarcaDAOHibernate;
import br.com.bariHosh.entidade.Marca;

@FacesConverter("converterMarca")
public class ConverterMarca implements Converter{

//	private FornecedorDAOHibernate dao = new FornecedorDAOHibernate();
	private MarcaDAOHibernate dao = new MarcaDAOHibernate();
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		if(value != null && !value.trim().equals("")) {
			
			Marca marca = new Marca();
			Long id = Long.parseLong(value);
			
			marca = dao.carregar(Marca.class, id );
			
			return marca;
		}else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(value==null || value.equals("")) {
			
			return "";
			
		}else {
			
			return String.valueOf(((Marca)value).getId_marca());
		}
		
	}
	
	
}
