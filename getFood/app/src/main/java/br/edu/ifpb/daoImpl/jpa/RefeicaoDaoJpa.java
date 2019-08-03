package br.edu.ifpb.daoImpl.jpa;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import br.edu.ifpb.dao.RefeicaoDao;
import br.edu.ifpb.domain.Refeicao;

@Stateless
public class RefeicaoDaoJpa implements RefeicaoDao{
	
	@PersistenceContext
	private EntityManager em;
	
	private EntityTransaction tr;
	
	@PostConstruct
	private void init() {
		this.tr = em.getTransaction();		
	}

	@Override
	public void salvar(Refeicao object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Refeicao object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Refeicao object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Refeicao buscar(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Refeicao> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	


}
