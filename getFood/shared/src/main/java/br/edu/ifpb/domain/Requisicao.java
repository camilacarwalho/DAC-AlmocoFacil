package br.edu.ifpb.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.edu.ifpb.domain.enums.StatusRequisicao;

@SuppressWarnings("serial")
@Entity
public class Requisicao implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long id;
	@Column(length = 20)
	@Enumerated(EnumType.STRING)
	private StatusRequisicao statusRequisicao;
	private Refeicao refeicao;
	@CollectionTable
	private List<Aluno> alunos;
	private LocalDate dataInicial;
	private LocalDate dataFinal;
	@ManyToOne
	private Solicitacao solicitacao;
	@OneToMany(mappedBy="requisicao",cascade=CascadeType.ALL)
	private List<Autorizacao> autorizacoes;
	
	/************************************
	 * Procedimento que vincula todas as
	 * autorizações a esta requisição 
	 ************************************/
	private void vincularAutorizacoes() {
		for (Autorizacao autorizacao: autorizacoes) {
			autorizacao.setRequisicao(this);			
		}		
	}
	
	public Requisicao() {}

	public Requisicao(StatusRequisicao statusRequisicao, Refeicao refeicao, List<Aluno> alunos, LocalDate dataInicial,
			LocalDate dataFinal, Solicitacao solicitacao, List<Autorizacao> autorizacoes) {
		this.statusRequisicao = statusRequisicao;
		this.refeicao = refeicao;
		this.alunos = alunos;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.solicitacao = solicitacao;
		setAutorizacoes(autorizacoes);
	}

	public Requisicao(Long id, StatusRequisicao statusRequisicao, Refeicao refeicao, List<Aluno> alunos,
			LocalDate dataInicial, LocalDate dataFinal, Solicitacao solicitacao, List<Autorizacao> autorizacoes) {
		this.id = id;
		this.statusRequisicao = statusRequisicao;
		this.refeicao = refeicao;
		this.alunos = alunos;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.solicitacao = solicitacao;
		setAutorizacoes(autorizacoes);
	}
	
	/*******************************************************
	 * Pocedimento que faz a inclusão da autorização e também
	 * a vinculação desta autorização a esta Requisicao
	 *******************************************************/
	public void adicionarAutorizacao(Autorizacao autorizacao) {
		autorizacao.setRequisicao(this);
		autorizacoes.add(autorizacao);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StatusRequisicao getStatusRequisicao() {
		return statusRequisicao;
	}

	public void setStatusRequisicao(StatusRequisicao statusRequisicao) {
		this.statusRequisicao = statusRequisicao;
	}

	public Refeicao getRefeicao() {
		return refeicao;
	}

	public void setRefeicao(Refeicao refeicao) {
		this.refeicao = refeicao;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public LocalDate getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Solicitacao getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}

	public List<Autorizacao> getAutorizacoes() {
		return autorizacoes;
	}

	public void setAutorizacoes(List<Autorizacao> autorizacoes) {
		this.autorizacoes = autorizacoes;
		vincularAutorizacoes();
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
		Requisicao other = (Requisicao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
