package br.edu.ifpb.daoImpl.jpa;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.edu.ifpb.dao.SolicitacaoDao;
import br.edu.ifpb.domain.Solicitacao;
import br.edu.ifpb.domain.enums.StatusRequisicao;

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
        solicitacao = em.find(Solicitacao.class,key);
        return solicitacao;
    }

    @Override
    public List<Solicitacao> listar() {
        String jpql="SELECT s FROM Solicitacao s";
        TypedQuery<Solicitacao> query = em.createQuery(jpql, Solicitacao.class);
        return query.getResultList();
    }

	@Override
	public List<Solicitacao> buscarSolicitacoes(String requerente, StatusRequisicao statusRequisicao, int inicio, int quant) {
		String jpql ="SELECT DISTINCT(s) FROM Solicitacao s"
				+ " JOIN s.usuario u"
				+ " WHERE LOWER(u.pessoa.nome) LIKE :nome";
		jpql += statusRequisicao != null ? " AND s.statusRequisicao = :status":"";						
		jpql += " ORDER BY s.dataSolicitacao DESC";
		
		TypedQuery<Solicitacao> query = em
				.createQuery(jpql, Solicitacao.class)
				.setFirstResult(inicio)
				.setMaxResults(quant);
		query.setParameter("nome", "%"+requerente.toLowerCase()+"%");
		if (statusRequisicao != null)
			query.setParameter("status", statusRequisicao);
		return query.getResultList();
	}

	@Override
	public int quantBuscarSolicitacoes(String requerente, StatusRequisicao statusRequisicao) {
		String jpql ="SELECT COUNT(s.id) FROM Solicitacao s"
				+ " JOIN s.usuario u"
				+ " WHERE LOWER(u.pessoa.nome) LIKE :nome";
		jpql += statusRequisicao != null ? " AND s.statusRequisica = :status":"";
		TypedQuery<Long> query = em.createQuery(jpql, Long.class);
		query.setParameter("nome", "%"+requerente.toLowerCase()+"%");
		if (statusRequisicao != null)
			query.setParameter("status", statusRequisicao);
		Long qdt = query.getSingleResult(); 
		return qdt.intValue(); 
	}
	
	
    
    
}
