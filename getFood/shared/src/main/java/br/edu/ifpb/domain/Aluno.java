package br.edu.ifpb.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.edu.ifpb.domain.enums.UsuarioEnum;

@SuppressWarnings("serial")
@Entity
public class Aluno extends Usuario {

    @ManyToOne()
    @JoinColumn(nullable = false)
    private Curso curso;

    @ManyToOne()
    @JoinColumn(nullable = false)
    private Periodo periodoIngresso;

    public Aluno(String matricula, String senha, Pessoa pessoa, Curso curso, Periodo periodoIngresso) {
        super(matricula, senha, UsuarioEnum.ALUNO, pessoa);
        this.curso = curso;
        this.periodoIngresso = periodoIngresso;
    }

    public Aluno() {
    }

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
