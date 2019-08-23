package br.edu.ifpb.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.edu.ifpb.dao.SolicitacaoDao;
import br.edu.ifpb.domain.Solicitacao;
import br.edu.ifpb.domain.enums.StatusRequisicao;

@Stateless
public class SolicitacaoServiceImpl implements Serializable, SolicitacaoService{
	
	private static final long serialVersionUID = 4720544029628063100L;
		
	@EJB
	protected SolicitacaoDao solicitacaoDao;
	
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

	
	
	
	
	
	

}
