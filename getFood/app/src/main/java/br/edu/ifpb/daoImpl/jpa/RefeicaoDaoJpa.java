package br.edu.ifpb.daoImpl.jpa;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.edu.ifpb.dao.RefeicaoDao;
import br.edu.ifpb.domain.Refeicao;

@Stateless
public class RefeicaoDaoJpa implements RefeicaoDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void salvar(Refeicao object) {
		em.persist(object);
	}

	@Override
	public void remover(Refeicao object) {
		Refeicao refeicao = em.find(Refeicao.class, object.getId());
		em.remove(refeicao);
	}

	@Override
	public void atualizar(Refeicao object) {
		em.merge(object);
	}

	@Override
	public Refeicao buscar(Object key) {
		Refeicao refeicao = new Refeicao();
		refeicao = em.find(Refeicao.class, key);
		return refeicao;
	}

	@Override
	public List<Refeicao> listar() {
		String jpql = "SELECT r FROM Refeicao r" + " ORDER BY r.horaInicio";
		TypedQuery<Refeicao> query = em.createQuery(jpql, Refeicao.class);
		return query.getResultList();
	}

	@Override
	public Refeicao buscarPeloNome(String nome) {
		String jpql = "SELECT r FROM Refeicao r" 
				+ " WHERE r.nome = :nome";
		TypedQuery<Refeicao> query = em.createQuery(jpql, Refeicao.class);
		query.setParameter("nome", nome);
		return query.getSingleResult();
	}
	
	

}
