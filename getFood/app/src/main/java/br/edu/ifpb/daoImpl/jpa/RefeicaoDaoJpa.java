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
		try {
			tr.begin();
			em.persist(object);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
	}

	@Override
	public void remover(Refeicao object) {
		try {
			tr.begin();
			Refeicao refeicao = em.find(
					Refeicao.class, 
					object.getId());
			em.remove(refeicao);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
	}

	@Override
	public void atualizar(Refeicao object) {
		try {
			tr.begin();
			em.merge(object);			
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
	}

	@Override
	public Refeicao buscar(Object key) {
		Refeicao refeicao = new Refeicao();
		try {
			tr.begin();
			refeicao = em.find(Refeicao.class, key);
			tr.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();			
		}
		return refeicao;
	}

	@Override
	public List<Refeicao> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	


}
