package br.com.bariHosh.converter;





import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.bariHosh.daoHibernate.FabricanteDAOHibernate;
import br.com.bariHosh.entidade.Fabricante;

@FacesConverter("generiocConverter")
public class ConverterGenerico  implements Converter{
	
	private FabricanteDAOHibernate  fabricanteDao= new FabricanteDAOHibernate();
	

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value != null && !value.trim().equals("")) {
			Fabricante fabricante = new Fabricante();
			try {
				Long id = Long.parseLong(value);
				try {
					fabricante = fabricanteDao.carregar(Fabricante.class, id);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (NumberFormatException exception) {
				return null;
			}
			return fabricante;
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value == null || value.equals("")) {
			return "";
		} else {
			return String.valueOf(((Fabricante) value).getId_fabricante());
		}
	}
}



