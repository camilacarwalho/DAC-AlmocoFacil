package com.example.almocofacil.domain;

import com.example.almocofacil.domain.enums.StatusAutorizacao;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;


@SuppressWarnings("serial")
public class Autorizacao implements Serializable {

	private static final long serialVersionUID = 1412992105114662836L;

	private int autorizacaoId;
	private String matriculaAluno;
	private String nomeAluno;
	private Date data;
	private String refeicaoNome;
	private int refeicaoId;
	private StatusAutorizacao statusAutorizacao;
	private int requisicaoId;
	private boolean concluida;

	public Autorizacao() {}

	public Autorizacao(int autorizacaoId, String matriculaAluno, String nomeAluno, Date data, String refeicaoNome,
						   int refeicaoId, StatusAutorizacao statusAutorizacao, int requisicaoId, boolean concluida) {
		this.autorizacaoId = autorizacaoId;
		this.matriculaAluno = matriculaAluno;
		this.nomeAluno = nomeAluno;
		this.data = data;
		this.refeicaoNome = refeicaoNome;
		this.refeicaoId = refeicaoId;
		this.statusAutorizacao = statusAutorizacao;
		this.requisicaoId = requisicaoId;
		this.concluida = concluida;
	}

	public int getAutorizacaoId() {return autorizacaoId;}
	public void setAutorizacaoId(int autorizacaoId) {this.autorizacaoId = autorizacaoId;}
	public String getMatriculaAluno() {return matriculaAluno;}
	public void setMatriculaAluno(String matriculaAluno) {this.matriculaAluno = matriculaAluno;}
	public String getNomeAluno() {return nomeAluno;}
	public void setNomeAluno(String nomeAluno) {this.nomeAluno = nomeAluno;}
	public Date getData() {return data;}
	public void setData(Date data) {this.data = data;}
	public String getRefeicaoNome() {return refeicaoNome;}
	public void setRefeicaoNome(String refeicaoNome) {this.refeicaoNome = refeicaoNome;}
	public int getRefeicaoId() {return refeicaoId;}
	public void setRefeicaoId(int refeicaoId) {this.refeicaoId = refeicaoId;}
	public StatusAutorizacao getStatusAutorizacao() {return statusAutorizacao;}
	public void setStatusAutorizacao(StatusAutorizacao statusAutorizacao) {this.statusAutorizacao = statusAutorizacao;}
	public int getRequisicaoId() {return requisicaoId;}
	public void setRequisicaoId(int requisicaoId) {this.requisicaoId = requisicaoId;}
	public boolean isConcluida() {return concluida;}
	public void setConcluida(boolean concluida) {this.concluida = concluida;}

}
