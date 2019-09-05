package com.example.almocofacil.domain;

public class _Aluno {
    private String matricula;
    private String nome;

    public _Aluno(String matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public _Aluno() {
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
