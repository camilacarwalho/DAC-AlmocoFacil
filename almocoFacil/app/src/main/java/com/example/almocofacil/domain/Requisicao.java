package com.example.almocofacil.domain;

import com.example.almocofacil.domain.enums.StatusRequisicao;

import java.io.Serializable;
import java.util.Date;


public class Requisicao implements Serializable{
	private static final long serialVersionUID = 3997712216264687692L;
	private int solicitacaoId;
	private int requisicaoId;
	private Date dataSolicitacao;
	private String nomeRequerente;
	private String matriculaRequerente;
	private String descricao;
	private StatusRequisicao status;
	private String justificativa;
	private String refeicaoNome;
	private int refeicaoId;
	private Date dataInicio;
	private Date dataFinal;

	public Requisicao() {}

	public Requisicao(int solicitacaoId, int requisicaoId, Date dataSolicitacao, String nomeRequerente,
						  String matriculaRequerente, String descricao, StatusRequisicao status, String justificativa,
						  String refeicaoNome, int refeicaoId, Date dataInicio, Date dataFinal) {
		this.solicitacaoId = solicitacaoId;
		this.requisicaoId = requisicaoId;
		this.dataSolicitacao = dataSolicitacao;
		this.nomeRequerente = nomeRequerente;
		this.matriculaRequerente = matriculaRequerente;
		this.descricao = descricao;
		this.status = status;
		this.justificativa = justificativa;
		this.refeicaoNome = refeicaoNome;
		this.refeicaoId = refeicaoId;
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
	}

	public int getSolicitacaoId() {return solicitacaoId;}
	public void setSolicitacaoId(int solicitacaoId) {this.solicitacaoId = solicitacaoId;}
	public int getRequisicaoId() {return requisicaoId;}
	public void setRequisicaoId(int requisicaoId) {this.requisicaoId = requisicaoId;}
	public Date getDataSolicitacao() {return dataSolicitacao;}
	public void setDataSolicitacao(Date dataSolicitacao) {this.dataSolicitacao = dataSolicitacao;}
	public String getNomeRequerente() {return nomeRequerente;}
	public void setNomeRequerente(String nomeRequerente) {this.nomeRequerente = nomeRequerente;}
	public String getMatriculaRequerente() {return matriculaRequerente;}
	public void setMatriculaRequerente(String matriculaRequerente) {this.matriculaRequerente = matriculaRequerente;}
	public String getDescricao() {return descricao;}
	public void setDescricao(String descricao) {this.descricao = descricao;}
	public StatusRequisicao getStatus() {return status;}
	public void setStatus(StatusRequisicao status) {this.status = status;}
	public String getJustificativa() {return justificativa;}
	public void setJustificativa(String justificativa) {this.justificativa = justificativa;}
	public String getRefeicaoNome() {return refeicaoNome;}
	public void setRefeicaoNome(String refeicaoNome) {this.refeicaoNome = refeicaoNome;}
	public int getRefeicaoId() {return refeicaoId;}
	public void setRefeicaoId(int refeicaoId) {this.refeicaoId = refeicaoId;}
	public Date getDataInicio() {return dataInicio;}
	public void setDataInicio(Date dataInicio) {this.dataInicio = dataInicio;}
	public Date getDataFinal() {return dataFinal;}
	public void setDataFinal(Date dataFinal) {this.dataFinal = dataFinal;}
	
}
