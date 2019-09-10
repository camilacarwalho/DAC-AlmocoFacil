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
import javax.persistence.Query;

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
    public List<Autorizacao> buscar(LocalDate data) {
        String jpql = "SELECT a FROM Autorizacao a"
                + " WHERE a.data = :data";
        TypedQuery<Autorizacao> query = em.createQuery(jpql, Autorizacao.class);
        query.setParameter("data", data);
        return query.getResultList();
    }

    @Override
    public void alterarStatus(Long id, StatusAutorizacao statusAutorizacao) {
        String queryUpdate = "UPDATE Autorizacao a "
                + "SET a.statusAutorizacao = :statusAutorizacao "
                + "WHERE a.id = :id";

        Query query = em.createQuery(queryUpdate, Autorizacao.class);
        query.setParameter("statusAutorizacao", statusAutorizacao);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public List<AutorizacaoRR> listarAutorizacaoRR(int min, int quant, LocalDate dataInicial, LocalDate dataFinal) {
        String jpql="SELECT NEW br.edu.ifpb.domain.AutorizacaoRR(a.data,f.nome,a.statusAutorizacao,COUNT(a.id))" +
                " FROM Autorizacao a LEFT JOIN a.requisicao r JOIN r.refeicao f";
        jpql+= dataInicial!=null ? " WHERE a.data BETWEEN :dataInicial AND :dataFinal":"";
        jpql+=" GROUP BY a.data,f.nome,a.statusAutorizacao ORDER BY a.data DESC";
        TypedQuery<AutorizacaoRR> query = em.createQuery(jpql, AutorizacaoRR.class);
        if(dataInicial!=null){
            if(dataFinal==null){
                query.setParameter("dataInicial",dataInicial);
                query.setParameter("dataFinal",LocalDate.now());
            }else{
                query.setParameter("dataInicial",dataInicial);
                query.setParameter("dataFinal",dataFinal);
            }
        }
        query.setFirstResult(min).setMaxResults(quant);
        return query.getResultList();
    }

    @Override
    public int quantAutorizacaoRR(LocalDate dataInicial, LocalDate dataFinal) {
        String jpql="SELECT NEW br.edu.ifpb.domain.AutorizacaoRR(a.data,f.nome,a.statusAutorizacao,COUNT(a.id))" +
                " FROM Autorizacao a LEFT JOIN a.requisicao r JOIN r.refeicao f";
        jpql+= dataInicial!=null ? " WHERE a.data BETWEEN :dataInicial AND :dataFinal":"";
        jpql+=" GROUP BY a.data,f.nome,a.statusAutorizacao ORDER BY a.data DESC";
        TypedQuery<AutorizacaoRR> query = em.createQuery(jpql, AutorizacaoRR.class);
        if(dataInicial!=null){
            if(dataFinal==null){
                query.setParameter("dataInicial",dataInicial);
                query.setParameter("dataFinal",LocalDate.now());
            }else{
                query.setParameter("dataInicial",dataInicial);
                query.setParameter("dataFinal",dataFinal);
            }
        }
        return query.getResultList().size();
    }

}
