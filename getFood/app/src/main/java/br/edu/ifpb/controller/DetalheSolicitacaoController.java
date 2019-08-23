package br.edu.ifpb.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import br.edu.ifpb.domain.Solicitacao;
import br.edu.ifpb.service.SolicitacaoService;

@ViewScoped
@Named
public class DetalheSolicitacaoController  implements Serializable{
	
	private static final String PARAMETRO_SOLICITACAO_ID = "solic";

	private static final long serialVersionUID = 4553342920612648114L;
	
	@Inject
	private SolicitacaoService solicitacaoService;
	private Solicitacao solicitacao;
	
	@PostConstruct
	private void init() {
		solicitacao = lerSolicitacaoPeloParametro();		
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
	
	public String getParametroSolicitacaoId() {return PARAMETRO_SOLICITACAO_ID;}
	public Solicitacao getSolicitacao() {return solicitacao;}
	public void setSolicitacao(Solicitacao solicitacao) {this.solicitacao = solicitacao;}
	

}
