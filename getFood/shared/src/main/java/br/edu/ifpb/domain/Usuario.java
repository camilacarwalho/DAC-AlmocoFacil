package br.edu.ifpb.domain;

public class Usuario {

    private String cpf;
    private String email;
    private String nome;

    public Usuario() {
    }

    public Usuario(String cpf, String email, String nome) {
        this.cpf = cpf;
        this.email = email;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
