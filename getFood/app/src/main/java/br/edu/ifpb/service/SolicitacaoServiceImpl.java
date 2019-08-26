package br.edu.ifpb.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.edu.ifpb.dao.SolicitacaoDao;
import br.edu.ifpb.domain.Requisicao;
import br.edu.ifpb.domain.Solicitacao;
import br.edu.ifpb.domain.enums.StatusRequisicao;

@Stateless
public class SolicitacaoServiceImpl implements Serializable, SolicitacaoService{
	
	private static final long serialVersionUID = 4720544029628063100L;
		
	@EJB
	protected SolicitacaoDao solicitacaoDao;
	@EJB
	protected RequisicaoService requisicaoService;
	
	@PostConstruct
	private void init() {
		
	}

	@Override
	public List<Solicitacao> listar() {
		return solicitacaoDao.listar();
	}

	@Override
	public Solicitacao buscar(Long id) {
		return solicitacaoDao.buscar(id);
	}
	
	

	@Override
	public Solicitacao bucarPeloUsuario(Long id, String matricula) {		
		return solicitacaoDao.buscarPeloUsuario(id, matricula);
	}

	@Override
	public List<Solicitacao> buscarSolicitacoes(String requerente, StatusRequisicao statusRequisicao, int inicio, int termino) {
		return solicitacaoDao.buscarSolicitacoes(requerente, statusRequisicao, inicio, termino);
	}
	
	@Override
	public int quantBuscarSolicitacoes(String requerente, StatusRequisicao statusRequisicao) {		
		return solicitacaoDao.quantBuscarSolicitacoes(requerente, statusRequisicao);
	}
	
	@Override
	public List<Solicitacao> buscarPelaMatricula(String matricula, StatusRequisicao statusRequisicao, int inicio,
			int termino) {		
		return solicitacaoDao.buscarPelaMatricula(matricula, inicio, termino, statusRequisicao);
	}

	@Override
	public int quantBuscarPelaMatricula(String matricula, StatusRequisicao statusRequisicao) {		
		return solicitacaoDao.quantSolicitacoresPelaMatricula(matricula, statusRequisicao);
	}

	@Override
	public void atualizar(Solicitacao solicitacao) {
		if (solicitacao.getStatusRequisicao() == StatusRequisicao.AUTORIZADA)
			solicitacao.setJustificativa("");
		solicitacaoDao.atualizar(solicitacao);
	}
	

	@Override
	public void salvar(Solicitacao solicitacao) {
		solicitacaoDao.salvar(solicitacao);
		
	}

	@Override
	public void atualizarStatusSolicitação(Solicitacao solicitacao) {
		int quantRequisicoes = solicitacao.getRequisicoes().size();
		StatusRequisicao statusRequisicao = StatusRequisicao.PENDENTE;
		if(quantRequisicoes > 0) {
			statusRequisicao = solicitacao.getRequisicoes().get(0).getStatusRequisicao();
			boolean continuar = statusRequisicao != StatusRequisicao.PENDENTE && quantRequisicoes > 1; //Se a requisição estiver pendente tudo está pendente
			int k = 1;			
			while (continuar) {
				switch (solicitacao.getRequisicoes().get(k).getStatusRequisicao()) {
				case PENDENTE: statusRequisicao = StatusRequisicao.PENDENTE;
					break;
				case AUTORIZADA:
					if(statusRequisicao != StatusRequisicao.AUTORIZADA)
						if(statusRequisicao == StatusRequisicao.NEGADA)
							statusRequisicao = StatusRequisicao.PARCIAL;						
					break;
				case NEGADA:
					if(statusRequisicao != StatusRequisicao.NEGADA) {
						if(statusRequisicao == StatusRequisicao.AUTORIZADA)
							statusRequisicao = StatusRequisicao.PARCIAL;
						else if(statusRequisicao == StatusRequisicao.COMPULSORIA)
							statusRequisicao = StatusRequisicao.PARCIAL;
					}
					break;
				case COMPULSORIA:
					if(statusRequisicao != StatusRequisicao.COMPULSORIA) {
						if(statusRequisicao == StatusRequisicao.NEGADA)
							statusRequisicao = StatusRequisicao.PARCIAL;
						else if(statusRequisicao == StatusRequisicao.AUTORIZADA)
							statusRequisicao = StatusRequisicao.COMPULSORIA;
					}				
				default:
					break;
				}
				
				continuar = continuar && (statusRequisicao != StatusRequisicao.PENDENTE); //Se for pendente caia fora
				continuar = continuar && (++k < quantRequisicoes);				
			}
		}
		solicitacao.setStatusRequisicao(statusRequisicao);
		this.atualizar(solicitacao);
	}

	@Override
	public boolean isEncerrada(Solicitacao solicitacao) {
		for (Requisicao requisicao: solicitacao.getRequisicoes())
			if(!requisicaoService.isEncerrada(requisicao))
				return false;
		return true;
	}

	@Override
	public boolean podeAutorizar(Solicitacao solicitacao) {
		if (this.isEncerrada(solicitacao))
			return false;
		for (Requisicao requisicao : solicitacao.getRequisicoes()) {
			boolean pode = requisicaoService.podeAutorizar(requisicao);			
			pode = pode || requisicao.getStatusRequisicao() == StatusRequisicao.AUTORIZADA;
			pode = pode || requisicao.getStatusRequisicao() == StatusRequisicao.COMPULSORIA;
			if (!pode) return false;
		}
		
		switch (solicitacao.getStatusRequisicao()) {
			case PENDENTE: return true;
			case AUTORIZADA: return false;
			case NEGADA: return true;
			case COMPULSORIA: return false;
			case PARCIAL: return true;
			default: return true;
		}
	}

	@Override
	public boolean podeNegar(Solicitacao solicitacao) {
		if (this.isEncerrada(solicitacao))
			return false;	
		for(Requisicao requisicao : solicitacao.getRequisicoes()) {
			boolean pode = requisicaoService.podeNegar(requisicao);
			pode = pode || requisicao.getStatusRequisicao() == StatusRequisicao.NEGADA;
			if (!pode) return false;
		}
		
		switch (solicitacao.getStatusRequisicao()) {
			case PENDENTE: return true;
			case AUTORIZADA: return true;
			case NEGADA: return false;
			case COMPULSORIA: return false;
			case PARCIAL: return true;
			default: return true;
		}
	}

	@Override
	public void negar(Solicitacao solicitacao) {
		if (!this.podeNegar(solicitacao))
			return;
		for (Requisicao requisicao : solicitacao.getRequisicoes()) 
			requisicaoService.negar(requisicao);
		solicitacao.setStatusRequisicao(StatusRequisicao.NEGADA);
		this.atualizar(solicitacao);
	}

	@Override
	public void autorizar(Solicitacao solicitacao) {
		if (!this.podeAutorizar(solicitacao))
			return;
		for(Requisicao requisicao : solicitacao.getRequisicoes())
			requisicaoService.autorizar(requisicao);
		solicitacao.setStatusRequisicao(StatusRequisicao.AUTORIZADA);
		this.atualizar(solicitacao);		
	}

	@Override
	public void autorizarCompulsoriamente(Solicitacao solicitacao) {
		if (!podeAutorizar(solicitacao)) return;
		for (Requisicao requisicao : solicitacao.getRequisicoes())
			requisicaoService.autorizarCompulsoriamente(requisicao);
		solicitacao.setStatusRequisicao(StatusRequisicao.COMPULSORIA);
		this.atualizar(solicitacao);		
	}

	@Override
	public void negarRequisicao(Requisicao requisicao) {
		this.requisicaoService.negar(requisicao);
		this.atualizarStatusSolicitação(requisicao.getSolicitacao());
		
	}

	@Override
	public void autorizarRequisicao(Requisicao requisicao) {
		requisicaoService.autorizar(requisicao);
		this.atualizarStatusSolicitação(requisicao.getSolicitacao());		
	}

	@Override
	public void autorizarCompulsoriamente(Requisicao requisicao) {
		requisicaoService.autorizarCompulsoriamente(requisicao);
		this.atualizarStatusSolicitação(requisicao.getSolicitacao());		
	}
	
	
	

}
