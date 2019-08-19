package br.edu.ifpb.daoImpl.jpa;

import br.edu.ifpb.dao.SolicitacaoDao;
import br.edu.ifpb.domain.Solicitacao;
import br.edu.ifpb.domain.enums.StatusRequisicao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
	public List<Solicitacao> buscarSolicitacaos(String requerente, StatusRequisicao statusRequisicao) {
		String jpql ="SELECT s FROM Solicitacao s"
				+ " JOIN s.usuario u"
				+ " WHERE LOWER(u.pessoa.nome) LIKE :nome";
		TypedQuery<Solicitacao> query = em.createQuery(jpql, Solicitacao.class);
		query.setParameter("nome", requerente.toLowerCase());
		return query.getResultList();
	}
    
    
}
