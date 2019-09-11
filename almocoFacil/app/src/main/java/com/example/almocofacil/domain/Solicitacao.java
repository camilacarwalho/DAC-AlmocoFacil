package com.example.almocofacil.domain;


import com.example.almocofacil.domain.enums.StatusRequisicao;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Solicitacao implements Serializable {
	
	private Long id;
	private LocalDate dataSolicitacao;
	private Usuario usuario;
	private String descricao;
	private String justificativa;
	private StatusRequisicao statusRequisicao;
	private List<Requisicao> requisicoes;
	

	public Solicitacao() {
		super();
		this.requisicoes = new ArrayList<Requisicao>();
	}

	public Solicitacao(LocalDate dataSolicitacao, Usuario usuario, String descricao, String justificativa, StatusRequisicao statusRequisicao,
			List<Requisicao> requisicoes) {
		this();
		this.dataSolicitacao = dataSolicitacao;
		this.usuario = usuario;
		this.descricao = descricao;
		this.justificativa = justificativa;
		this.statusRequisicao = statusRequisicao;
		setRequisicoes(requisicoes);
	}

	public Solicitacao(Long id, LocalDate dataSolicitacao, Usuario usuario, String descricao, String justificativa,
			StatusRequisicao statusRequisicao, List<Requisicao> requisicoes) {
		this();
		this.id = id;
		this.dataSolicitacao = dataSolicitacao;
		this.usuario = usuario;
		this.descricao = descricao;
		this.justificativa = justificativa;
		this.statusRequisicao = statusRequisicao;
		setRequisicoes(requisicoes);
	}
	
	/*******************************************************
	 * Pocedimento que faz a inclusão da requisicao e também
	 * a vinculação desta requesição a esta Solicitação
	 *******************************************************/
	public void adicionarRequisicao(Requisicao requisicao) {
		requisicoes.add(requisicao);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(LocalDate dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public StatusRequisicao getStatusRequisicao() {
		return statusRequisicao;
	}

	public void setStatusRequisicao(StatusRequisicao statusRequisicao) {
		this.statusRequisicao = statusRequisicao;
	}

	public List<Requisicao> getRequisicoes() {
		return requisicoes;
	}

	public void setRequisicoes(List<Requisicao> requisicoes) {
		this.requisicoes = requisicoes;
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
		Solicitacao other = (Solicitacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
