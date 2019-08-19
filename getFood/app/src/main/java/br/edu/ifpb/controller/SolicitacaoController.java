package br.edu.ifpb.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.domain.Solicitacao;
import br.edu.ifpb.domain.enums.StatusRequisicao;
import br.edu.ifpb.service.SolicitacaoService;


@ViewScoped
@Named
public class SolicitacaoController implements Serializable {
	
	@Inject
	private SolicitacaoService solicitacaoService;
	private String buscarRequerente;
	private StatusRequisicao buscarStatusRequisicao;
	private List<Solicitacao> solicitacoes;
	
	@PostConstruct
	private void init() {
		buscarRequerente = "";
		buscarStatusRequisicao = null;
		atualizar();
	}
	
	public String atualizar() {
		solicitacoes = solicitacaoService.buscarSolicitacoes(buscarRequerente, buscarStatusRequisicao);		
		return "";
	}
	
	public List<Solicitacao> getListSolicitacao(){		
		return solicitacoes;
	}
	
	public StatusRequisicao[] getlistaStatusRequisicao() {return StatusRequisicao.values();	}
	public String getBuscarRequerente() {return buscarRequerente;}
	public void setBuscarRequerente(String buscarRequerente) {this.buscarRequerente = buscarRequerente;}
	public StatusRequisicao getBuscarStatusRequisicao() {return buscarStatusRequisicao;}
	public void setBuscarStatusRequisicao(StatusRequisicao buscarStatusRequisicao) {this.buscarStatusRequisicao = buscarStatusRequisicao;}
	
	
	

}
