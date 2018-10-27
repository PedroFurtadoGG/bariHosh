package br.com.bariHosh.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.com.bariHosh.daoHibernate.UsuarioDAOHibernate;
import br.com.bariHosh.entidade.Usuario;

public class ManuseioPublico {

	public static boolean validaCPF(String CPF) {

		List<String> strings = new ArrayList<String>();
		strings.addAll(Arrays.asList(CPF.split("\\.|-")));
		CPF = "";
		for (String str : strings) {
			CPF = CPF + "" + str;
		}

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

	public Usuario buscarPorUsuarioLogado() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		String login = external.getRemoteUser();
		return new UsuarioDAOHibernate().buscarPorLogin(login);
	}

	
	
	public static boolean CalcularIdade(Date data) {
		Calendar dateOfBirth = new GregorianCalendar();
		dateOfBirth.setTime(data);
		Calendar today = Calendar.getInstance();
		Integer tempoData = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
		dateOfBirth.add(Calendar.YEAR, tempoData);
		if (today.before(dateOfBirth)) {
			tempoData--;		}
		return tempoData >= 18;
		
	}
	
	
	public static boolean CalcularDataValidadeProduto(Date data) {				
		   return  CalcularData(data)<=0;
		}
	
	public static Integer CalcularData(Date data) {
		Calendar dateOfBirth = new GregorianCalendar();
		dateOfBirth.setTime(data);
		Calendar today = Calendar.getInstance();
		Integer tempoData = today.get(Calendar.DAY_OF_MONTH) - dateOfBirth.get(Calendar.DAY_OF_MONTH);
		dateOfBirth.add(Calendar.DAY_OF_MONTH, tempoData);
		if (today.before(dateOfBirth)) {
			tempoData--;		}
		return tempoData ;
	}

	public static void MessagesSucesso(String mensagem) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, null);
		context.addMessage(null, facesMessage);
	}

	public static void MessagesErro(String mensagem) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, null);
		context.addMessage(null, facesMessage);
	}

	public static void MessagesInfo(String mensagem) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_FATAL, mensagem, null);
		context.addMessage(null, facesMessage);
	}

}
