package br.edu.ifpb.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.edu.ifpb.domain.enums.StatusRequisicao;

@Entity
public class Requisicao {
	
	@Id
	private int id;
	@Enumerated(EnumType.STRING)
	private StatusRequisicao statusRequisicao;
	private Refeicao refeicao;
	@CollectionTable
	private List<Aluno> alunos;
	@Temporal(TemporalType.DATE)
	private LocalDate dataInicial;
	@Temporal(TemporalType.DATE)
	private LocalDate dataFinal;
	
	public Requisicao() {}

	public Requisicao(int id, StatusRequisicao statusRequisicao, Refeicao refeicao, List<Aluno> alunos,
			LocalDate dataInicial, LocalDate dataFinal) {
		super();
		this.id = id;
		this.statusRequisicao = statusRequisicao;
		this.refeicao = refeicao;
		this.alunos = alunos;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setStatusRequisicao(StatusRequisicao statusRequisicao) {
		this.statusRequisicao = statusRequisicao;
	}

	public void setRefeicao(Refeicao refeicao) {
		this.refeicao = refeicao;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}

	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
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
		Requisicao other = (Requisicao) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
