package br.edu.ifpb.domain;

import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Refeicao implements Serializable {
	
	@Id
	private Long id;
	private String nome;
	@Temporal(TemporalType.TIME)
	private LocalTime horaInicio;
	@Temporal(TemporalType.TIME)
	private LocalTime horaTermino;
	
	public Refeicao() {	}
	
	public Refeicao(String nome, LocalTime horaInicio, LocalTime horaTermino) {
		super();
		this.nome = nome;
		this.horaInicio = horaInicio;
		this.horaTermino = horaTermino;
	}

	public Refeicao(Long id, String nome, LocalTime horaInicio, LocalTime horaTermino) {
		this.id = id;
		this.nome = nome;
		this.horaInicio = horaInicio;
		this.horaTermino = horaTermino;
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
		Refeicao other = (Refeicao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

}
