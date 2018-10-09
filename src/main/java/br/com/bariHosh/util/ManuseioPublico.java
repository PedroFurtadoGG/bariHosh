package br.com.bariHosh.util;


import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Objects;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.com.bariHosh.daoHibernate.UsuarioDAOHibernate;
import br.com.bariHosh.entidade.Usuario;

public class ManuseioPublico {

	public static boolean isCPF(String CPF) {

		if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222")
				|| CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555")
				|| CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888")
				|| CPF.equals("99999999999") || (CPF.length() != 11))
			return (false);

		char dig10, dig11;
		int sm, i, r, num, peso;

		try {

			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {

				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48);
			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}
	}

	public static boolean validaObjeto(Object obj) {
		return !Objects.isNull(obj);
	}

	public Integer CalcularIdade(String dataNascimento) {
		DateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");

		Date dataNascInput = null;
		try {

			dataNascInput = dataFormatada.parse(dataNascimento);

		} catch (Exception e) {
		}

		Calendar dateOfBirth = new GregorianCalendar();

		dateOfBirth.setTime(dataNascInput);

		Calendar today = Calendar.getInstance();

		Integer idade = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);

		dateOfBirth.add(Calendar.YEAR, idade);

		if (today.before(dateOfBirth)) {
			idade--;
		}

		return idade;
	}

	public Usuario buscarPorUsuarioLogado() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		String login = external.getRemoteUser();
		return new UsuarioDAOHibernate().buscarPorLogin(login);
	}


	
	/**
	 * calcula a idade do candidato recebe a data de nascimento como Date 
	 * e retorna a idade como tipo Integer
	 * **/
	
	public static Integer CalcularIdade(Date dataNascimento) {

		Calendar dateOfBirth = new GregorianCalendar();

		dateOfBirth.setTime(dataNascimento);

		// Cria um objeto calendar com a data atual

		Calendar today = Calendar.getInstance();

		// Obtendo a idade baseado no ano

		Integer idade = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);

		dateOfBirth.add(Calendar.YEAR, idade);

		if (today.before(dateOfBirth)) {
			idade--;
		}
		
		return idade;
	}
	
	
	public static void MessagesSucesso(String mensagem) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
				mensagem, null);
		context.addMessage(null, facesMessage);
	}

	public static void MessagesErro(String mensagem) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,
				mensagem, null);
		context.addMessage(null, facesMessage);
	}
	
     public static void MessagesInfo(String mensagem) {
    	 FacesContext context = FacesContext.getCurrentInstance();
    	 FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_FATAL,
					mensagem, null);
			context.addMessage(null, facesMessage);
    }
	

}
