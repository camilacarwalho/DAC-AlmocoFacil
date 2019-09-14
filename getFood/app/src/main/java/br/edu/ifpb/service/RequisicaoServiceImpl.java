package br.edu.ifpb.service;

import java.time.LocalDate;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.edu.ifpb.dao.RequisicaoDao;
import br.edu.ifpb.domain.Aluno;
import br.edu.ifpb.domain.Requisicao;
import br.edu.ifpb.domain.enums.StatusRequisicao;
import java.util.List;

@Stateless
public class RequisicaoServiceImpl implements RequisicaoService {
	
	@EJB
	RequisicaoDao requisicaoDao;

	@Override
	public Requisicao buscar(long id) {		
		return requisicaoDao.buscar(id);
	}

	@Override
	public boolean adicionarAluno(Requisicao requisicao, Aluno aluno) {
		if (requisicao == null || aluno == null)
			return false;
		requisicao.getAlunos().add(aluno);
		requisicaoDao.atualizar(requisicao);
		return true;
	}
	
	

	@Override
	public boolean definirAlunos(Requisicao requisicao, List<Aluno> alunos) {		
		if (! podeAlterar(requisicao))
			return false;
		requisicao.setAlunos(alunos);
		requisicaoDao.atualizar(requisicao);
		return true;
	}

	@Override
	public boolean isEncerrada(Requisicao requisicao) {
		return LocalDate.now().isAfter(requisicao.getDataFinal());
	}

	@Override
	public void negar(Requisicao requisicao) {
		if (!podeNegar(requisicao))
			return;
		requisicao.setStatusRequisicao(StatusRequisicao.NEGADA);
		requisicaoDao.atualizar(requisicao);		
	}

	@Override
	public void autorizar(Requisicao requisicao) {
		if(!podeAutorizar(requisicao))
			return;
		requisicao.setStatusRequisicao(StatusRequisicao.AUTORIZADA);
		requisicaoDao.atualizar(requisicao);
	}

	@Override
	public void autorizarCompulsoriamente(Requisicao requisicao) {
		if(!podeAutorizar(requisicao))
			return;
		requisicao.setStatusRequisicao(StatusRequisicao.COMPULSORIA);
		requisicaoDao.atualizar(requisicao);
	}

	@Override
	public void atualizar(Requisicao requisicao) {
		requisicaoDao.atualizar(requisicao);
	}

	@Override
	public boolean podeAutorizar(Requisicao requisicao) {
		if (isEncerrada(requisicao))
			return false;
		switch (requisicao.getStatusRequisicao()) {
			case PENDENTE: return true;
			case AUTORIZADA: return false;
			case NEGADA: return true;
			case COMPULSORIA: return false;
			//case PARCIAL: return true; // Não existe parcial em Requisição
			default: return true;
		}
	}

	@Override
	public boolean podeNegar(Requisicao requisicao) {
		if (isEncerrada(requisicao))
			return false;
		switch (requisicao.getStatusRequisicao()) {
			case PENDENTE: return true;
			case AUTORIZADA: return true;
			case NEGADA: return false;
			case COMPULSORIA: return false;
			//case PARCIAL: return true; // Não existe parcial em Requisição
			default: return true;
		}
	}

    @Override
    public List<Requisicao> buscarRequisicoes(StatusRequisicao statusRequisicao, LocalDate data) {
        return requisicaoDao.buscarPeloStatus(statusRequisicao, data);
    }

	@Override
	public boolean podeAlterar(Requisicao requisicao) {
		return (!isEncerrada(requisicao))  && (requisicao.getStatusRequisicao() == StatusRequisicao.PENDENTE);  
	}
    
    
    
}
