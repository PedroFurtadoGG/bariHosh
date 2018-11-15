package br.com.bariHosh.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.bariHosh.daoHibernate.ClienteDAOHibernate;
import br.com.bariHosh.entidade.Cliente;

@FacesConverter("converterCliente")
public class ClienteConverter 	 implements Converter {


		
		private ClienteDAOHibernate dao = new ClienteDAOHibernate();
		
		@Override
		public Object getAsObject(FacesContext context, UIComponent component, String value) {
			
			if(value != null && !value.trim().equals("")) {
				
				Cliente cliente = new Cliente();
				Long id = Long.parseLong(value);
				
				cliente= dao.carregar(Cliente.class, id );
				
				return cliente;
			}else {
				return null;
			}
		}

		@Override
		public String getAsString(FacesContext context, UIComponent component, Object value) {
			
			if(value==null || value.equals("")) {
				
				return "";
				
			}else {
				
				return String.valueOf(((Cliente)value).getId_cliente());
			}
			
		}

	}
