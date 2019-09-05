package com.example.almocofacil.domain;

import com.example.almocofacil.domain.enums.UsuarioEnum;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements Serializable {

    private String matricula;
    private String senha;
    private UsuarioEnum cargo;
    private Pessoa pessoa;
    private List<Solicitacao> solicitacoes;

    public Usuario() {
    	solicitacoes = new ArrayList<Solicitacao>();
    }

    public Usuario(String matricula, String senha, UsuarioEnum cargo,Pessoa pessoa) {
    	this();
        this.matricula = matricula;
        this.senha = senha;
        this.cargo = cargo;
        this.pessoa=pessoa;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public UsuarioEnum getCargo() {
        return cargo;
    }

    public void setCargo(UsuarioEnum cargo) {
        this.cargo = cargo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
	public List<Solicitacao> getSolicitacoes() {
		return solicitacoes;
	}

	public void setSolicitacoes(List<Solicitacao> solicitacoes) {
		for (Solicitacao solicitacao : solicitacoes) {
			solicitacao.setUsuario(this);
		}
		this.solicitacoes = solicitacoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
   
}

