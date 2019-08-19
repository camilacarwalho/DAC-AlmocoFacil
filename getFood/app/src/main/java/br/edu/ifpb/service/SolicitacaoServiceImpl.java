package br.edu.ifpb.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.edu.ifpb.dao.SolicitacaoDao;
import br.edu.ifpb.domain.Solicitacao;

@Stateless
public class SolicitacaoServiceImpl implements Serializable, SolicitacaoService{

	private static final long serialVersionUID = 4720544029628063100L;
	
	@EJB
	private SolicitacaoDao solicitacaoDao;

	@Override
	public List<Solicitacao> listar() {
		return solicitacaoDao.listar();
	}

}
