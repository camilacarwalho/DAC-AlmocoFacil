package com.example.almocofacil.domain;

import com.example.almocofacil.domain.enums.StatusAutorizacao;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;


@SuppressWarnings("serial")
public class Autorizacao implements Serializable {
	

	private Long id;
	private Aluno aluno;
	private LocalDate data;
	private LocalTime hora;
	private Refeicao refeicao;
	private StatusAutorizacao statusAutorizacao;
	private Requisicao requisicao;
	
	public Autorizacao() {	}

	public Autorizacao(Aluno aluno, LocalDate data, LocalTime hora, Refeicao refeicao,
			StatusAutorizacao statusAutorizacao, Requisicao requisicao) {
		super();
		this.aluno = aluno;
		this.data = data;
		this.hora = hora;
		this.refeicao = refeicao;
		this.statusAutorizacao = statusAutorizacao;
		this.requisicao = requisicao;
	}

	public Autorizacao(Long id, Aluno aluno, LocalDate data, LocalTime hora, Refeicao refeicao,
			StatusAutorizacao statusAutorizacao, Requisicao requisicao) {
		super();
		this.id = id;
		this.aluno = aluno;
		this.data = data;
		this.hora = hora;
		this.refeicao = refeicao;
		this.statusAutorizacao = statusAutorizacao;
		this.requisicao = requisicao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Requisicao getRequisicao() {
		return requisicao;
	}

	public void setRequisicao(Requisicao requisicao) {
		this.requisicao = requisicao;
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
		Autorizacao other = (Autorizacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
