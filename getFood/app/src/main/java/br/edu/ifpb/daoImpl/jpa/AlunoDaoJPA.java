package br.edu.ifpb.daoImpl.jpa;

import br.edu.ifpb.dao.AlunoDao;
import br.edu.ifpb.domain.Aluno;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class AlunoDaoJPA implements AlunoDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void salvar(Aluno object) {
        em.persist(object);
    }

    @Override
    public void remover(Aluno object) {
        Aluno aluno = buscar(object.getMatricula());
        em.remove(aluno);
    }

    @Override
    public void atualizar(Aluno object) {
        em.merge(object);
    }

    @Override
    public Aluno buscar(Object key) {
        Aluno aluno = new Aluno();
        aluno= em.find(Aluno.class,key);
        return aluno;
    }

    @Override
    public List<Aluno> listar() {
        String jpql = "SELECT a FROM Aluno a";
        TypedQuery<Aluno> query = em.createQuery(jpql, Aluno.class);
        return query.getResultList();
    }

    @Override
    public int quantBuscarAlunos(String matricula) {
        String jpql = "SELECT COUNT(a.matricula) FROM Aluno a ";
        jpql+= !(matricula==null||matricula.isEmpty()) ? " WHERE a.matricula LIKE :matricula":"";
        TypedQuery<Long> query = em.createQuery(jpql, Long.class);
        if(!(matricula==null||matricula.isEmpty())){
            query.setParameter("matricula","%"+matricula+"%");
        }
        Long result = query.getSingleResult();
        return result.intValue();
    }

    @Override
    public List<Aluno> buscarAlunos(int min, int quant,String matricula) {
        String jpql = "SELECT a FROM Aluno a ";
        jpql+= !(matricula==null||matricula.isEmpty()) ? " WHERE a.matricula LIKE :matricula":"";
        TypedQuery<Aluno> query = em.createQuery(jpql, Aluno.class)
                .setFirstResult(min)
                .setMaxResults(quant);
        if(!(matricula==null||matricula.isEmpty())){
            query.setParameter("matricula","%"+matricula+"%");
        }
        return query.getResultList();

    }
}
