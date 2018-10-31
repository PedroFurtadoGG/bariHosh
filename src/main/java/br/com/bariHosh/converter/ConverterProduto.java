package br.com.bariHosh.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.bariHosh.daoHibernate.ProdutoDAOHibernate;
import br.com.bariHosh.entidade.Produto;

@FacesConverter("converterProduto")
public class ConverterProduto implements Converter {
	
	private ProdutoDAOHibernate dao = new ProdutoDAOHibernate();
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		if(value != null && !value.trim().equals("")) {
			
			Produto produto = new Produto();
			Long id = Long.parseLong(value);
			
			produto= dao.carregar(Produto.class, id );
			
			return produto;
		}else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(value==null || value.equals("")) {
			
			return "";
			
		}else {
			
			return String.valueOf(((Produto)value).getId_produto());
		}
		
	}

}
