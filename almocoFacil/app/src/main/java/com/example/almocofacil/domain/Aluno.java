package com.example.almocofacil.domain;

public class Aluno {
    private String matricula;
    private String nome;
    private String cpf;
    private String curso;
    private String telefone;

    public Aluno() {}

    public Aluno(String matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public Aluno(String matricula, String nome, String cpf, String curso, String telefone) {
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.curso = curso;
        this.telefone = telefone;
    }

    public String getMatricula() {return matricula;}
    public void setMatricula(String matricula) {this.matricula = matricula;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getCpf() {return cpf;}
    public void setCpf(String cpf) {this.cpf = cpf;}
    public String getCurso() {return curso;}
    public void setCurso(String curso) {this.curso = curso;}
    public String getTelefone() {return telefone;}
    public void setTelefone(String telefone) {this.telefone = telefone;}
}
