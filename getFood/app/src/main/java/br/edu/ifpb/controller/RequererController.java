package br.edu.ifpb.controller;


import java.time.LocalDate;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.domain.Requisicao;
import br.edu.ifpb.domain.Solicitacao;
import br.edu.ifpb.domain.enums.StatusRequisicao;
import br.edu.ifpb.service.SolicitacaoService;

@ViewScoped
@Named
public class RequererController extends SolicitacaoController{
	
	private static final long serialVersionUID = 8613967402379279410L;
	
	@Inject
	SolicitacaoService solicitacaoService;

	@Override
	protected Solicitacao novaSolicitacao() {return new Solicitacao();}
	@Override
	protected void salvarSolicitacao() {solicitacaoService.salvar(getSolicitacao());}
	@Override
	protected void atualizarSolicitacao() {solicitacaoService.atualizar(getSolicitacao());}
	@Override
	protected Solicitacao buscarSolicitacao(Long id, String matricula) {return solicitacaoService.bucarPeloUsuario(id,matricula);}
	
	@Override
	protected boolean podeSalvarSolicitacao(Solicitacao solicitacao) {
		if(solicitacao.getStatusRequisicao() != StatusRequisicao.PENDENTE) {
			MessagesAlert.addErrorMessage("Não é possível modificar a solicitação processada.");
			return false;
		}
		return true;
	}

	@Override
	protected boolean podeSalvarRequisicao(Requisicao requisicao) {

		if(requisicao.getDataInicial().isBefore(LocalDate.now().plusDays(1))) {
			MessagesAlert.addErrorMessage("Data da requisição inválida.");
			return false;
		}
		return true;
	}

}
