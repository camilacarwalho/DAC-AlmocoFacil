package br.edu.ifpb.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import br.edu.ifpb.domain.enums.StatusRequisicao;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Solicitacao implements Serializable{
	
	@Id
	private Long id;
	private LocalDate dataSolicitacao;
	private Usuario usuario;
	private String descricao;
	@Enumerated(EnumType.STRING)
	private StatusRequisicao statusRequisicao;
	@OneToMany(mappedBy="solicitacao", cascade=CascadeType.ALL)
	private List<Requisicao> requisicoes;
	
	/************************************
	 * Procedimento que vincula todas as
	 * requisições a esta solicitação 
	 ************************************/
	private void vincularRequisicoes() {
		for (Requisicao requisicao : requisicoes) {
			requisicao.setSolicitacao(this);			
		}		
	}
	
	public Solicitacao() {}

	public Solicitacao(LocalDate dataSolicitacao, Usuario usuario, String descricao, StatusRequisicao statusRequisicao,
			List<Requisicao> requisicoes) {
		super();
		this.dataSolicitacao = dataSolicitacao;
		this.usuario = usuario;
		this.descricao = descricao;
		this.statusRequisicao = statusRequisicao;
		setRequisicoes(requisicoes);
	}

	public Solicitacao(Long id, LocalDate dataSolicitacao, Usuario usuario, String descricao,
			StatusRequisicao statusRequisicao, List<Requisicao> requisicoes) {
		super();
		this.id = id;
		this.dataSolicitacao = dataSolicitacao;
		this.usuario = usuario;
		this.descricao = descricao;
		this.statusRequisicao = statusRequisicao;
		setRequisicoes(requisicoes);
	}
	
	/*******************************************************
	 * Pocedimento que faz a inclusão da requisicao e também
	 * a vinculação desta requesição a esta Solicitação
	 *******************************************************/
	public void adicionarRequisicao(Requisicao requisicao) {
		requisicao.setSolicitacao(this);
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
		vincularRequisicoes();
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
