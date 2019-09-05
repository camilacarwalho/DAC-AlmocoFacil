package com.example.almocofacil.domain;

import com.example.almocofacil.domain.enums.NivelCurso;
import com.example.almocofacil.domain.enums.TurnoCurso;

import java.io.Serializable;

public class Curso implements Serializable{

    private String codigo;
    private String nome;
    private NivelCurso nivel;
    private TurnoCurso turno;

    public Curso() {
    }

	public Curso(String codigo, String nome, NivelCurso nivel, TurnoCurso turno) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.nivel = nivel;
		this.turno = turno;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
   
}
