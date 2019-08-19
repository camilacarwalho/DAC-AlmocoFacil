package br.edu.ifpb.controller;

import java.io.Serializable;

import javax.ejb.Remove;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.service.MensagensAlert;
import br.edu.ifpb.service.UsuarioService;

@SessionScoped
@Named
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = -6290167856098791005L;
	
	private String matricula;
	private String senha;
	
	@Inject
    private UsuarioService usuarioService;
	
	public String logon() {
		if (usuarioService.logar(matricula, senha) == null) {
			MensagensAlert.addErrorMessage("Falha ao autenticar usuário.");
			return null;
		}		
		return  usuarioService.getUsuarioEnum().getIdentificador();
	}
	
	@Remove
	public String logout() {
		usuarioService.logout();
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "home";
	}
	
	public String getMensagem() {return "Ambiente do " + usuarioService.getUsuarioEnum().getNome();}
	public String getMatricula() {return matricula;}
	public void setMatricula(String matricula) {this.matricula = matricula;}
	public String getSenha() {return senha;}
	public void setSenha(String senha) {this.senha = senha;}
	
	

}
