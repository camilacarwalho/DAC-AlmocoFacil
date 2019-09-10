package com.example.almocofacil.domain;

import com.example.almocofacil.domain.enums.UsuarioEnum;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements Serializable {

    private static final long serialVersionUID = 2199055059890496813L;
    private String matricula;
    private String senha;
    private UsuarioEnum cargo;
    private String cpf;
    private String nome;
    private String telefone;

    public Usuario() {}

    public Usuario(String matricula, String senha) {
        this.matricula = matricula;
        this.senha = senha;
    }

    public Usuario(String matricula, String senha, UsuarioEnum cargo, String cpf, String nome, String telefone) {
        this.matricula = matricula;
        this.senha = senha;
        this.cargo = cargo;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getMatricula() {return matricula;}
    public void setMatricula(String matricula) {this.matricula = matricula;}
    public String getSenha() {return senha;}
    public void setSenha(String senha) {this.senha = senha;}
    public UsuarioEnum getCargo() {return cargo;}
    public void setCargo(UsuarioEnum cargo) {this.cargo = cargo;}
    public String getCpf() {return cpf;}
    public void setCpf(String cpf) {this.cpf = cpf;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getTelefone() {return telefone;}
    public void setTelefone(String telefone) {this.telefone = telefone;}
}

