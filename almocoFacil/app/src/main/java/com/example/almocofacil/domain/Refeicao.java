package com.example.almocofacil.domain;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;
import java.util.Timer;

public class Refeicao implements Serializable {
	
	private Long id;
	private String nome;
	private Date horaInicio;
	private Date horaTermino;
	
	public Refeicao() {	}
	
	public Refeicao(String nome, Date horaInicio, Date horaTermino) {
		super();
		this.nome = nome;
		this.horaInicio = horaInicio;
		this.horaTermino = horaTermino;
	}

	public Refeicao(Long id, String nome, Date horaInicio, Date horaTermino) {
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

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getHoraTermino() {
		return horaTermino;
	}

	public void setHoraTermino(Date horaTermino) {
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
