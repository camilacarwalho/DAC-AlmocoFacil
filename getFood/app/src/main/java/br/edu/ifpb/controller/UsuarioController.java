package br.edu.ifpb.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.Remove;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.dao.PessoaDao;
import br.edu.ifpb.domain.Pessoa;
import br.edu.ifpb.domain.Usuario;
import br.edu.ifpb.domain.enums.UsuarioEnum;
import br.edu.ifpb.service.UsuarioService;

@SessionScoped
@Named
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = -6290167856098791005L;

	private Usuario usuarioNovo;
	private Pessoa pessoa;

	private String matricula;
	private String senha;
	private String nome;
	private String telefone;
	private String latitude;
	private String longitude;
	
	@Inject
    private UsuarioService usuarioService;


	@PostConstruct
	public void init(){
		pessoa = new Pessoa();
		pessoa.setUsuarios(new ArrayList<>());
		usuarioNovo = new Usuario();
	}
	
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

	public String salvar(){
		usuarioNovo.setPessoa(this.pessoa);
		usuarioService.salvar(this.usuarioNovo);
		this.usuarioNovo = new Usuario();
		this.pessoa = new Pessoa();
		return "index.xhtml";
	}

	public UsuarioEnum[] tipoUsuario(){
		return UsuarioEnum.values();
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
	public String getLatitude() {return latitude;}
	public void setLatitude(String latitude) {this.latitude = latitude;}
	public String getLongitude() {return longitude;}
	public void setLongitude(String longitude) {this.longitude = longitude;}

	public Usuario getUsuarioNovo() {
		return usuarioNovo;
	}

	public void setUsuarioNovo(Usuario usuarioNovo) {
		this.usuarioNovo = usuarioNovo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
