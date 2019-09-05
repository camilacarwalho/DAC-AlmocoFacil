package com.example.almocofacil.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Pessoa implements Serializable{

    private String cpf;
    private String nome;
    private String telefone;
    private List<Usuario> usuarios;


    public Pessoa() {
    }

    public Pessoa(String cpf, String nome, String telefone, List<Usuario> usuarios) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.usuarios = usuarios;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(cpf, pessoa.cpf) &&
                Objects.equals(nome, pessoa.nome) &&
                Objects.equals(telefone, pessoa.telefone) &&
                Objects.equals(usuarios, pessoa.usuarios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, nome, telefone, usuarios);
    }
}
