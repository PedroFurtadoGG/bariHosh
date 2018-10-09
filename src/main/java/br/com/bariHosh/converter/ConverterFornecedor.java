package br.com.bariHosh.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.bariHosh.daoHibernate.FornecedorDAOHibernate;
import br.com.bariHosh.entidade.Fornecedor;

@FacesConverter("converterFornecedor")
public class ConverterFornecedor implements Converter{
	
	private FornecedorDAOHibernate dao = new FornecedorDAOHibernate();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		if(value != null && !value.trim().equals("")) {
			
			Fornecedor fornecedor = new Fornecedor();
			Long id = Long.parseLong(value);
			
			fornecedor = dao.carregar(Fornecedor.class, id );
			
			return fornecedor;
		}else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(value==null || value.equals("")) {
			
			return "";
			
		}else {
			
			return String.valueOf(((Fornecedor)value).getId_fornecedor());
		}
		
	}

}
