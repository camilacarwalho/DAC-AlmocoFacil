package br.edu.ifpb.daoImpl.jpa;

import br.edu.ifpb.dao.RequisicaoDao;
import br.edu.ifpb.domain.Refeicao;
import br.edu.ifpb.domain.Requisicao;
import br.edu.ifpb.domain.enums.StatusRequisicao;
import java.time.LocalDate;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class RequisicaoDaoJPA implements RequisicaoDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void salvar(Requisicao object) {
        em.persist(object);
    }

    @Override
    public void remover(Requisicao object) {
        Requisicao requisicao = buscar(object.getId());
        em.remove(requisicao);
    }

    @Override
    public void atualizar(Requisicao object) {
        em.merge(object);
    }

    @Override
    public Requisicao buscar(Object key) {
        Requisicao requisicao = new Requisicao();
        requisicao = em.find(Requisicao.class,key);
        return requisicao;
    }

    @Override
    public List<Requisicao> listar() {
        String jpql="SELECT r FROM Requisicao r";
        TypedQuery<Requisicao> query = em.createQuery(jpql, Requisicao.class);
        return query.getResultList();
    }

    @Override
    public List<Requisicao> buscarPeloStatus(StatusRequisicao statusRequisicao, LocalDate data) {
         String jpql = "SELECT r FROM Requisicao r"
                + " WHERE r.statusRequisicao = :status"
                + " AND :data BETWEEN r.dataInicial AND r.dataFinal";

        TypedQuery<Requisicao> query = em.createQuery(jpql, Requisicao.class);
        query.setParameter("status", statusRequisicao);
        query.setParameter("data", data);
        return query.getResultList();
    }

	@Override
	public List<Requisicao> buscarDataRefeicao(LocalDate data, Refeicao refeicao) {
        String jpql = "SELECT DISTINCT(r) FROM Requisicao r"
        		+ " JOIN r.refeicao e"
                + " WHERE (r.statusRequisicao = :auto"
                + " OR r.statusRequisicao = :comp)"
                + " AND e.id = :id"
                + " AND :data BETWEEN r.dataInicial AND r.dataFinal";

        TypedQuery<Requisicao> query = em.createQuery(jpql, Requisicao.class);
        query.setParameter("auto", StatusRequisicao.AUTORIZADA);
        query.setParameter("comp", StatusRequisicao.COMPULSORIA);
        query.setParameter("id", refeicao.getId());
        query.setParameter("data", data);
        return query.getResultList();
	}
    
    
}
