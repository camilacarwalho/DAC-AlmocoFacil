package br.edu.ifpb.daoImpl.jpa;

import br.edu.ifpb.dao.EditalDao;
import br.edu.ifpb.domain.Edital;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class EditalDaoJPA implements EditalDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void salvar(Edital object) {
        em.persist(object);
    }

    @Override
    public void remover(Edital object) {
        Edital edital = buscar(object.getCodigo());
        em.remove(edital);
    }

    @Override
    public void atualizar(Edital object) {
        em.merge(object);
    }

    @Override
    public Edital buscar(Object key) {
        Edital edital = new Edital();
        edital = em.find(Edital.class,key);
        return edital;
    }

    @Override
    public List<Edital> listar() {
        String jpql="SELECT e FROM Edital e";
        TypedQuery<Edital> query = em.createQuery(jpql, Edital.class);
        return query.getResultList();
    }
}
