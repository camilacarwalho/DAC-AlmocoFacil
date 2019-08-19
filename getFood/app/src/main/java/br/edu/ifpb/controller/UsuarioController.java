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
	private String nome;
	private String telefone;
	
	@Inject
    private UsuarioService usuarioService;
	
	public String logon() {
		if (usuarioService.logar(matricula, senha) == null) {
			MensagensAlert.addErrorMessage("Falha ao autenticar usuário.");
			return null;
		}		
		senha = "";
		return  usuarioService.getUsuarioEnum().getIdentificador();
	}
	
	@Remove
	public String logout() {
		usuarioService.logout();
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "home";
	}
	
	public String editar() {
		if(senha == null || senha.isEmpty())
			senha = usuarioService.getUsuarioLogado().getSenha();
		try {
			usuarioService.editar(nome, telefone, senha);
		}catch (Exception e) {
			MensagensAlert.addErrorMessage("Falha ao editar dados.");
			return null;
		}
		MensagensAlert.addInfoMessage("Dados modificados");
		nome = "";
		telefone = "";
		senha = "";
		return "";
	}
	
	public String getMensagem() {return "Ambiente do " + usuarioService.getUsuarioEnum().getNome();}
	public String getMatricula() {return matricula;}
	public void setMatricula(String matricula) {this.matricula = matricula;}
	public String getSenha() {return senha;}
	public void setSenha(String senha) {this.senha = senha;}
	public String getNome() {return usuarioService.getUsuarioLogado().getPessoa().getNome();}
	public void setNome(String nome) {this.nome = nome;}
	public String getCpf() {return usuarioService.getUsuarioLogado().getPessoa().getCpf();}
	public String getTelefone() {return usuarioService.getUsuarioLogado().getPessoa().getTelefone();}
	public void setTelefone(String telefone) {this.telefone = telefone;}
	public String getCargo() {return usuarioService.getUsuarioLogado().getCargo().getNome();}
	
	

}
