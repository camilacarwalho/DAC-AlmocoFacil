package br.edu.ifpb.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MessagesAlert {
	
	public static void addInfoMessage(String msg) {
		FacesMessage infoMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, 
	            "Informação: ", msg);
	        FacesContext.getCurrentInstance().addMessage(null, infoMessage);
	}
	
	public static void addWarningMessage(String msg) {
		FacesMessage warningMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, 
				"Atenção: ", msg);
	        FacesContext.getCurrentInstance().addMessage(null, warningMessage);
	}
	
	public static void addErrorMessage(String msg) {
		FacesMessage errorMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
				"Erro: ", msg);
	        FacesContext.getCurrentInstance().addMessage(null, errorMessage);
	}
	
	public static void addFatalMessage(String msg) {
		FacesMessage fatalMessage = new FacesMessage(FacesMessage.SEVERITY_FATAL, 
				"Fatal: ", msg);
	        FacesContext.getCurrentInstance().addMessage(null, fatalMessage);
	}
	

}
