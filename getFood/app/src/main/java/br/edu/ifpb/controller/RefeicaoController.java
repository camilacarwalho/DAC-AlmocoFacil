package br.edu.ifpb.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.dao.RefeicaoDao;
import br.edu.ifpb.domain.Refeicao;

@SuppressWarnings("serial")
@RequestScoped
@Named
public class RefeicaoController implements Serializable{

//	@Inject
	@EJB
	private RefeicaoDao refeicaoDao;
	
	public List<Refeicao> getListaDeRefeicoes(){
		return refeicaoDao.listar();
	}

}
