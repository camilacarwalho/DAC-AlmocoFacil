package br.edu.ifpb.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.edu.ifpb.domain.enums.NivelCurso;
import br.edu.ifpb.domain.enums.TurnoCurso;

@SuppressWarnings("serial")
@Entity
public class Curso implements Serializable{

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private NivelCurso nivel;
    @Column(nullable = false)
    private TurnoCurso turno;

    public Curso() {
    }

    public Curso(Long id, String nome, NivelCurso nivel, TurnoCurso turno) {
        this.id = id;
        this.nome = nome;
        this.nivel = nivel;
        this.turno = turno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Curso other = (Curso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
   
}
