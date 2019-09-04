package br.edu.ifpb.daoImpl.jpa;

import br.edu.ifpb.dao.AutorizacaoDao;
import br.edu.ifpb.domain.Autorizacao;
import br.edu.ifpb.domain.AutorizacaoRR;
import br.edu.ifpb.domain.enums.StatusAutorizacao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
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

    @Override
    public List<AutorizacaoRR> listarAutorizacaoRR(int min, int quant, StatusAutorizacao statusAutorizacao, LocalDate dataInicial, LocalDate dataFinal) {
        String jpql="SELECT NEW br.edu.ifpb.domain.AutorizacaoRR(a.data,f.nome,a.statusAutorizacao,COUNT(a.id))" +
                " FROM Autorizacao a JOIN Requisicao r ON a.requisicao_id=r.id JOIN" +
                " Refeicao f ON r.refeicao_id=f.id";
        jpql+=!(dataInicial==null||dataFinal==null) ? " WHERE a.data BETWEEN :dataInicial AND :dataFinal":"";
        jpql+=!(statusAutorizacao==null) ? " AND a.statusAutorizacao=:status ":"";
        jpql+=" GROUP BY a.data,f.nome,a.statusAutorizacao ORDER BY a.data DESC";
        TypedQuery<AutorizacaoRR> query = em.createQuery(jpql, AutorizacaoRR.class);
        if(!(dataInicial==null||dataFinal==null)){
            query.setParameter("dataInicial",dataInicial);
            query.setParameter("dataFinal",dataFinal);
        }
        if(statusAutorizacao!=null){
            query.setParameter("status",statusAutorizacao);
        }
        query.setFirstResult(min).setMaxResults(quant);
        return query.getResultList();
    }

    @Override
    public int quantAutorizacaoRR(StatusAutorizacao statusAutorizacao, LocalDate dataInicial, LocalDate dataFinal) {
        String jpql="SELECT COUNT(a.id)" +
                " FROM Autorizacao a JOIN Requisicao r ON a.requisicao_id=r.id JOIN" +
                " Refeicao f ON r.refeicao_id=f.id";
        jpql+=!(dataInicial==null||dataFinal==null) ? " WHERE a.data BETWEEN :dataInicial AND :dataFinal":"";
        jpql+=!(statusAutorizacao==null) ? " AND a.statusAutorizacao=:status ":"";
        TypedQuery<Long> query = em.createQuery(jpql, Long.class);
        if(!(dataInicial==null||dataFinal==null)){
            query.setParameter("dataInicial",dataInicial);
            query.setParameter("dataFinal",dataFinal);
        }
        if(statusAutorizacao!=null){
            query.setParameter("status",statusAutorizacao);
        }
        Long quant = query.getSingleResult();
        return quant.intValue();
    }
}
