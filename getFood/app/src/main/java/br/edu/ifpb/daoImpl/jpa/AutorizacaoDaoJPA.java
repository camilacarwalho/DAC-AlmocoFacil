package br.edu.ifpb.daoImpl.jpa;

import br.edu.ifpb.dao.AutorizacaoDao;
import br.edu.ifpb.domain.Autorizacao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class AutorizacaoDaoJPA implements AutorizacaoDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void salvar(Autorizacao object) {
        em.persist(object);
    }

    @Override
    public void remover(Autorizacao object) {
        Autorizacao autorizacao = buscar(object.getId());
        em.remove(autorizacao);
    }

    @Override
    public void atualizar(Autorizacao object) {
        em.merge(object);
    }

    @Override
    public Autorizacao buscar(Object key) {
        Autorizacao autorizacao = new Autorizacao();
        autorizacao = em.find(Autorizacao.class,key);
        return autorizacao;
    }

    @Override
    public List<Autorizacao> listar() {
        String jpql="SELECT at FROM Autorizacao at";
        TypedQuery<Autorizacao> query = em.createQuery(jpql, Autorizacao.class);
        return query.getResultList();
    }
}
