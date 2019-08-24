package br.edu.ifpb.service;

import java.io.Serializable;
import java.time.LocalDate;
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
	public List<Solicitacao> buscarSolicitacoes(String requerente, StatusRequisicao statusRequisicao, int inicio, int termino) {
		return solicitacaoDao.buscarSolicitacoes(requerente, statusRequisicao, inicio, termino);
	}

	@Override
	public int quantBuscarSolicitacoes(String requerente, StatusRequisicao statusRequisicao) {		
		return solicitacaoDao.quantBuscarSolicitacoes(requerente, statusRequisicao);
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
		solicitacaoDao.atualizar(solicitacao);
	}

	@Override
	public void autorizar(Solicitacao solicitacao) {
		if (!this.podeAutorizar(solicitacao))
			return;
		for(Requisicao requisicao : solicitacao.getRequisicoes())
			requisicaoService.autorizar(requisicao);
		solicitacao.setStatusRequisicao(StatusRequisicao.NEGADA);
		solicitacaoDao.atualizar(solicitacao);		
	}

	@Override
	public void autorizarCompulsoriamente(Solicitacao solicitacao) {
		if (!podeAutorizar(solicitacao)) return;
		for (Requisicao requisicao : solicitacao.getRequisicoes())
			requisicaoService.autorizarCompulsoriamente(requisicao);
		solicitacao.setStatusRequisicao(StatusRequisicao.COMPULSORIA);
		solicitacaoDao.atualizar(solicitacao);		
	}
	

}
