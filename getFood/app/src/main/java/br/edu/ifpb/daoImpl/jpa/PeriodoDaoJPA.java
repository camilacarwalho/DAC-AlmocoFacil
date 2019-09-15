package br.edu.ifpb.daoImpl.jpa;

import br.edu.ifpb.dao.PeriodoDao;
import br.edu.ifpb.domain.Periodo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class PeriodoDaoJPA implements PeriodoDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void salvar(Periodo object) {
        em.persist(object);
    }

    @Override
    public void remover(Periodo object) {
        Periodo periodo = buscar(object.getCodigo());
        em.remove(periodo);
    }

    @Override
    public void atualizar(Periodo object) {
        em.merge(object);
    }

    @Override
    public Periodo buscar(Object key) {
        Periodo periodo = new Periodo();
        periodo = em.find(Periodo.class, key);
        return periodo;
    }

    @Override
    public List<Periodo> listar() {
        String jpql="SELECT p FROM Periodo p";
        TypedQuery<Periodo> query = em.createQuery(jpql, Periodo.class);
        return query.getResultList();
    }

    @Override
    public Periodo buscarPorAno(int ano) {
        String jpql="SELECT p FROM Periodo p WHERE ano = " + ano;
        TypedQuery<Periodo> query = em.createQuery(jpql, Periodo.class);
        return query.getSingleResult();
    }

    @Override
    public Periodo buscarPorPeriodo(int periodo) {
        String jpql="SELECT p FROM Periodo p WHERE periodo = " + periodo;
        TypedQuery<Periodo> query = em.createQuery(jpql, Periodo.class);
        return query.getSingleResult();
    }

}
