package br.edu.ifpb.daoImpl.jpa;

import br.edu.ifpb.dao.CursoDao;
import br.edu.ifpb.domain.Curso;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class CursoDaoJPA implements CursoDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void salvar(Curso curso) {
        em.persist(curso);
    }

    @Override
    public void remover(Curso curso) {
        Curso curso1 = buscar(curso.getCodigo());
        em.remove(curso1);
    }

    @Override
    public void atualizar(Curso curso) {
        em.merge(curso);
    }

    @Override
    public Curso buscar(Object key) {
        Curso curso = new Curso();
        curso = em.find(Curso.class,key);
        return curso;
    }

    @Override
    public List<Curso> listar() {
        String jpql = "SELECT c FROM Curso c";
        TypedQuery<Curso> query = em.createQuery(jpql, Curso.class);
        return query.getResultList();
    }

}
