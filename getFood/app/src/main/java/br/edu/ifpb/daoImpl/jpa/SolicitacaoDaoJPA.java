package br.edu.ifpb.daoImpl.jpa;

import br.edu.ifpb.dao.SolicitacaoDao;
import br.edu.ifpb.domain.Solicitacao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class SolicitacaoDaoJPA implements SolicitacaoDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void salvar(Solicitacao object) {
        em.persist(object);
    }

    @Override
    public void remover(Solicitacao object) {
        Solicitacao solicitacao = buscar(object.getId());
        em.remove(solicitacao);
    }

    @Override
    public void atualizar(Solicitacao object) {
        em.merge(object);

    }

    @Override
    public Solicitacao buscar(Object key) {
        Solicitacao solicitacao = new Solicitacao();
        return em.find(Solicitacao.class,key);
    }

    @Override
    public List<Solicitacao> listar() {
        String jpql="SELECT s FROM Solicitacao s";
        TypedQuery<Solicitacao> query = em.createQuery(jpql, Solicitacao.class);
        return query.getResultList();

    }
}
