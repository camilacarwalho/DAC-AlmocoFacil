package br.edu.ifpb.controller;

import java.io.Serializable;

import javax.ejb.Remove;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.domain.Usuario;
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
	
	private void encerrarSessao() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}
	
	public String logon() {
		if (usuarioService.logar(matricula, senha) == null) {
			MessagesAlert.addErrorMessage("Falha ao autenticar usuário.");
			return null;
		}		
		senha = "";
		return  usuarioService.getUsuarioEnum().getIdentificador();
	}
	
	@Remove
	public String logout() {
		usuarioService.logout();
		encerrarSessao();
		return "home";
	}
	
	public String editar() {
		if(senha == null || senha.isEmpty())
			senha = usuarioService.getUsuarioLogado().getSenha();
		try {
			usuarioService.editar(nome, telefone, senha);
		}catch (Exception e) {
			MessagesAlert.addErrorMessage("Falha ao editar dados.");
			return null;
		}
		MessagesAlert.addInfoMessage("Dados modificados");
		nome = "";
		telefone = "";
		senha = "";
		return "";
	}
	
	public String desativar() {
		usuarioService.desativar();
		encerrarSessao();
		return "home";
	}
	public Usuario getUsuario() {return usuarioService.getUsuarioLogado(); }
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
