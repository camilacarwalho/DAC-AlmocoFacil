package br.edu.ifpb.service;

import javax.ejb.EJB;

import br.edu.ifpb.dao.RefeicaoDao;
import br.edu.ifpb.domain.Refeicao;

public class RefeicaoServiceImpl implements RefeicaoService{
	
	@EJB
	RefeicaoDao refeicaoDao;

	@Override
	public Refeicao buscarPeloNome(String nome) {		
		return refeicaoDao.buscarPeloNome(nome);
	}

}
