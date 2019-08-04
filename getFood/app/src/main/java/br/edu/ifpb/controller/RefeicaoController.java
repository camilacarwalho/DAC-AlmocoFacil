package br.edu.ifpb.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.edu.ifpb.dao.RefeicaoDao;
import br.edu.ifpb.daoImpl.jpa.RefeicaoDaoJpa;
import br.edu.ifpb.domain.Refeicao;

@Stateless
public class RefeicaoController implements Serializable{

	@PersistenceContext
	private EntityManager em;

	private RefeicaoDao refeicaoDao;

	@PostConstruct
	void init(){
		this.refeicaoDao=new RefeicaoDaoJpa(em);
	}
	
	public List<Refeicao> getListaDeRefeicoes(){
		return refeicaoDao.listar();
	}

}
