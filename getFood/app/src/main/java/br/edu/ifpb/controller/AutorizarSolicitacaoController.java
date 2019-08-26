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
public class AutorizarSolicitacaoController extends PaginacaoController<Solicitacao> implements Serializable {
	
	private static final long serialVersionUID = 6246947493370034923L;
	
	@Inject
	private SolicitacaoService solicitacaoService;
	private String buscarRequerente;
	private StatusRequisicao buscarStatusRequisicao;
	
	@PostConstruct
	private void init() {
		buscarRequerente = "";
		buscarStatusRequisicao = null;
		buscar();
	}
	
	@Override
	protected List<Solicitacao> listarItensDaBusca(int inicio, int maximo) {
		return solicitacaoService.buscarSolicitacoes(
				buscarRequerente,
			 	buscarStatusRequisicao, 
			 	inicio, 
			 	maximo);
	}

	@Override
	public int getQuantidadeItens() {
		return solicitacaoService.quantBuscarSolicitacoes(buscarRequerente, buscarStatusRequisicao);
	}
	
	public boolean podeAutorizar(Solicitacao solicitacao) {
		return solicitacaoService.podeAutorizar(solicitacao);
	}
	
	public boolean podeNegar(Solicitacao solicitacao) {
		return solicitacaoService.podeNegar(solicitacao);
	}
	
	public String autorizar(Solicitacao solicitacao) {
		if (!this.podeAutorizar(solicitacao)) {
			MessagesAlert.addErrorMessage("Não é possível autorizar esta solicitação.");
			return null;			
		}
		solicitacaoService.autorizar(solicitacao);
		MessagesAlert.addInfoMessage("Solicitação autorizada.");
		return "";			
	}
	
	public String negar(Solicitacao solicitacao) {
		if (!this.podeNegar(solicitacao)) {
			MessagesAlert.addErrorMessage("Não é possível negar esta solicitação.");
			return null;			
		}
		solicitacaoService.negar(solicitacao);
		MessagesAlert.addInfoMessage("Solicitação negada.");
		return "";
	}

	public List<Solicitacao> getListSolicitacao(){return getItens();}
	public StatusRequisicao[] getlistaStatusRequisicao() {return StatusRequisicao.values();	}
	public String getBuscarRequerente() {return buscarRequerente;}
	public void setBuscarRequerente(String buscarRequerente) {this.buscarRequerente = buscarRequerente;}
	public StatusRequisicao getBuscarStatusRequisicao() {return buscarStatusRequisicao;}
	public void setBuscarStatusRequisicao(StatusRequisicao buscarStatusRequisicao) {this.buscarStatusRequisicao = buscarStatusRequisicao;}

}
