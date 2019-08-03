package br.edu.ifpb.domain;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Refeicao {
	
	@Id
	private int id;
	private String nome;
	@Temporal(TemporalType.TIME)
	private LocalTime horaInicio;
	@Temporal(TemporalType.TIME)
	private LocalTime horaTermino;
	
	public Refeicao() {	}

	public Refeicao(int id, String nome, LocalTime horaInicio, LocalTime horaTermino) {
		this.id = id;
		this.nome = nome;
		this.horaInicio = horaInicio;
		this.horaTermino = horaTermino;
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

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraTermino() {
		return horaTermino;
	}

	public void setHoraTermino(LocalTime horaTermino) {
		this.horaTermino = horaTermino;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Refeicao other = (Refeicao) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
