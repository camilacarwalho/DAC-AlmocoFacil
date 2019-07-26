package br.edu.ifpb.domain;

import br.edu.ifpb.domain.enums.NivelCurso;
import br.edu.ifpb.domain.enums.TurnoCurso;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Curso {

    @Id
    private int id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private NivelCurso nivel;
    @Column(nullable = false)
    private TurnoCurso turno;

    public Curso() {
    }

    public Curso(int id, String nome, NivelCurso nivel, TurnoCurso turno) {
        this.id = id;
        this.nome = nome;
        this.nivel = nivel;
        this.turno = turno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public NivelCurso getNivel() {
        return nivel;
    }

    public void setNivel(NivelCurso nivel) {
        this.nivel = nivel;
    }

    public TurnoCurso getTurno() {
        return turno;
    }

    public void setTurno(TurnoCurso turno) {
        this.turno = turno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return id == curso.id &&
                Objects.equals(nome, curso.nome) &&
                nivel == curso.nivel &&
                turno == curso.turno;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, nivel, turno);
    }
}
