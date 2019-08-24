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
public class AcompanharSolicitacaoController extends PaginacaoController<Solicitacao>  implements Serializable {
	
	@Inject
	UsuarioController usuarioController;
	@Inject
	SolicitacaoService solicitacaoService;
	StatusRequisicao statusRequisicao;
	
	@PostConstruct
	private void init() {
		statusRequisicao = null;
		buscar();
	}

	@Override
	protected List<Solicitacao> listarItensDaBusca(int inicio, int maximo) {		
		return solicitacaoService.buscarPelaMatricula(
				getMatricula(), 
				this.statusRequisicao, 
				inicio, 
				maximo);
	}

	@Override
	public int getQuantidadeItens() {		
		return solicitacaoService.quantBuscarPelaMatricula(
				getMatricula(),
				this.statusRequisicao);
	}
	
	public StatusRequisicao[] getListarStatus() {return StatusRequisicao.values();}
	
	public String getNome() {return usuarioController.getNome();}
	public String getMatricula() {return usuarioController.getMatricula();}
	public StatusRequisicao getStatusRequisicao() {return statusRequisicao;}
	public void setStatusRequisicao(StatusRequisicao statusRequisicao) {this.statusRequisicao = statusRequisicao;}
	

}
