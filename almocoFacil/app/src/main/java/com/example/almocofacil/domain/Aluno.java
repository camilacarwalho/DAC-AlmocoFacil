package com.example.almocofacil.domain;

import java.util.Objects;

import static com.example.almocofacil.domain.enums.UsuarioEnum.ALUNO;


public class Aluno extends Usuario {

    private Curso curso;

    private Periodo periodoIngresso;

    public Aluno(String matricula, String senha, Pessoa pessoa, Curso curso, Periodo periodoIngresso) {
        super(matricula, senha, ALUNO, pessoa);
        this.curso = curso;
        this.periodoIngresso = periodoIngresso;
    }

    public Aluno(String matricula, String nome){
        super(matricula,
                "123",
                ALUNO,
                new Pessoa());
        this.getPessoa().setNome(nome);

    }



    public Aluno() {
    }

    public String getNome(){return getPessoa().getNome();}

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Periodo getPeriodoIngresso() {
        return periodoIngresso;
    }

    public void setPeriodoIngresso(Periodo periodoIngresso) {
        this.periodoIngresso = periodoIngresso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(curso, aluno.curso) &&
                Objects.equals(periodoIngresso, aluno.periodoIngresso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), curso, periodoIngresso);
    }
}
