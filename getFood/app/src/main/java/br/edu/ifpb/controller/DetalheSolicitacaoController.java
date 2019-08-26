package br.edu.ifpb.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import br.edu.ifpb.domain.Requisicao;
import br.edu.ifpb.domain.Solicitacao;
import br.edu.ifpb.service.RequisicaoService;
import br.edu.ifpb.service.SolicitacaoService;

@ViewScoped
@Named
public class DetalheSolicitacaoController  implements Serializable{
	
	private static final String PARAMETRO_SOLICITACAO_ID = "solic";

	private static final long serialVersionUID = 4553342920612648114L;
	
	@Inject
	private SolicitacaoService solicitacaoService;
	@Inject
	private RequisicaoService requisicaoService;
	private Solicitacao solicitacao;
	
	private String justificativa;
	private Long requisicaoId;
	
	
	@PostConstruct
	private void init() {
		solicitacao = lerSolicitacaoPeloParametro();
		justificativa = solicitacao.getJustificativa();
	}
	
	private String lerParametro(String parametro) {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		return request.getParameter(parametro);
	}
	
	private Solicitacao lerSolicitacaoPeloParametro() {
		Solicitacao solicitacao = null;
		String solicStr = lerParametro(PARAMETRO_SOLICITACAO_ID);
		if (solicStr != null && !solicStr.isEmpty()) {
			Long solicId;
			try {
				solicId = Long.valueOf(solicStr);
			}catch (Exception e) {
				solicId = 0L;
			}
			solicitacao = solicitacaoService.buscar(solicId);
		}
		return solicitacao != null ? solicitacao : new Solicitacao();
	}
	
	public String solicitacaoAutorizar() {
		if (!this.solicitacaoPodeAutorizar()) {
			MessagesAlert.addErrorMessage("Não é possível autorizar esta solicitação.");
			return null;			
		}
		solicitacaoService.autorizar(this.solicitacao);
		MessagesAlert.addInfoMessage("Solicitação autorizada.");
		return "";
	}
	
	public String solicitacaoNegar() {
		if (!this.solicitacaoPodeNegar()) {
			MessagesAlert.addErrorMessage("Não é possível negar esta solicitação.");
			return null;			
		}
		solicitacaoService.negar(this.solicitacao);
		MessagesAlert.addInfoMessage("Solicitação negada.");
		return "";
	}
	
	public String requisicaoAutorizar(Requisicao requisicao) {
		if (!this.requisicaoPodeAutorizar(requisicao)) {
			MessagesAlert.addErrorMessage("Não é possível autorizar esta requisição.");
			return null;
		}
		MessagesAlert.addInfoMessage("Requisição autorizada.");
		solicitacaoService.autorizarRequisicao(requisicao);
		return "";
	}
	
	public String requisicaoNegar() {
		for (Requisicao requisicao : solicitacao.getRequisicoes()) {
			if(requisicao.getId().equals(requisicaoId))
				if(this.requisicaoPodeNegar(requisicao)) {
					MessagesAlert.addInfoMessage("Requisição negada.");
					solicitacao.setJustificativa(justificativa);
					solicitacaoService.negarRequisicao(requisicao);
					return "";
				} else break;
		}
		MessagesAlert.addErrorMessage("Não é possível negar esta requisição.");
		return null;
	}
	
	public boolean solicitacaoPodeAutorizar() {
		return solicitacaoService.podeAutorizar(solicitacao);
	}
	
	public boolean solicitacaoPodeNegar() {
		return solicitacaoService.podeNegar(solicitacao);
	}
	
	
	public boolean requisicaoPodeAutorizar(Requisicao requisicao) {
		return requisicaoService.podeAutorizar(requisicao);
	}
	
	public boolean requisicaoPodeNegar(Requisicao requisicao) {
		return requisicaoService.podeNegar(requisicao);
	}
	
	public String getParametroSolicitacaoId() {return PARAMETRO_SOLICITACAO_ID;}
	public Solicitacao getSolicitacao() {return solicitacao;}
	public void setSolicitacao(Solicitacao solicitacao) {this.solicitacao = solicitacao;}

	public String getJustificativa() {
		justificativa = solicitacao.getJustificativa();
		return justificativa;
	}
	public void setJustificativa(String justificativa) {this.justificativa = justificativa;}
	public Long getRequisicaoId() {return requisicaoId;}
	public void setRequisicaoId(Long requisicaoId) {this.requisicaoId = requisicaoId;}
	
	

}
