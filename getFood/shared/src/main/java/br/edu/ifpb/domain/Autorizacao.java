package br.edu.ifpb.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.edu.ifpb.domain.enums.StatusAutorizacao;

@SuppressWarnings("serial")
@Entity
public class Autorizacao implements Serializable {
	
	@Id
	private int id;
	private Aluno aluno;
	@Temporal(TemporalType.DATE)
	private LocalDate data;
	@Temporal(TemporalType.TIME)
	private LocalTime hora;
	private Refeicao refeicao;
	@Enumerated(EnumType.STRING)
	private StatusAutorizacao statusAutorizacao;
	
	public Autorizacao() {	}

	public Autorizacao(int id, Aluno aluno, LocalDate data, LocalTime hora, Refeicao refeicao,
			StatusAutorizacao statusAutorizacao) {
		super();
		this.id = id;
		this.aluno = aluno;
		this.data = data;
		this.hora = hora;
		this.refeicao = refeicao;
		this.statusAutorizacao = statusAutorizacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public Refeicao getRefeicao() {
		return refeicao;
	}

	public void setRefeicao(Refeicao refeicao) {
		this.refeicao = refeicao;
	}

	public StatusAutorizacao getStatusAutorizacao() {
		return statusAutorizacao;
	}

	public void setStatusAutorizacao(StatusAutorizacao statusAutorizacao) {
		this.statusAutorizacao = statusAutorizacao;
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
		Autorizacao other = (Autorizacao) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
