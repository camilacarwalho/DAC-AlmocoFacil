package br.edu.ifpb.daoImpl.jpa;

import br.edu.ifpb.dao.PessoaDao;
import br.edu.ifpb.domain.Pessoa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class PessoaDaoJPA implements PessoaDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void salvar(Pessoa object) {
        em.persist(object);
    }

    @Override
    public void remover(Pessoa object) {
        Pessoa pessoa = buscar(object.getCpf());
        em.remove(pessoa);
    }

    @Override
    public void atualizar(Pessoa object) {
        em.merge(object);
    }

    @Override
    public Pessoa buscar(Object key) {
        Pessoa pessoa = new Pessoa();
        pessoa = em.find(Pessoa.class,key);
        return pessoa;
    }

    @Override
    public List<Pessoa> listar() {
       String jpql = "SELECT p FROM Pessoa p";
       TypedQuery<Pessoa> query = em.createQuery(jpql, Pessoa.class);
       return query.getResultList();
    }
}
