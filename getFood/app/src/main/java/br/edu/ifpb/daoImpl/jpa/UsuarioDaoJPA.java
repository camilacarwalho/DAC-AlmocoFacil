package br.edu.ifpb.daoImpl.jpa;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.edu.ifpb.dao.UsuarioDao;
import br.edu.ifpb.domain.Usuario;

@Stateless
public class UsuarioDaoJPA implements UsuarioDao {

    @PersistenceContext
    private EntityManager em;


    @Override
    public void salvar(Usuario usuario) {
            em.persist(usuario);
    }

    @Override
    public void remover(Usuario usuario) {
            Usuario morto = buscar(usuario.getMatricula());
            em.remove(morto);
    }

    @Override
    public List<Usuario> listar() {
        String jpql = "SELECT u FROM Usuario u";
        TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
        return query.getResultList();
    }

    @Override
    public void atualizar(Usuario usuario) {
        em.merge(usuario);
    }

    @Override
    public Usuario buscar(Object matricula) {
        Usuario encontrado = new Usuario();
        encontrado = em.find(Usuario.class,matricula);
        return encontrado;

    }

    @Override
    public List<Usuario> buscarProfessores(int min, int quant,String matricula) {
        String jpql="SELECT u FROM Usuario u WHERE u.cargo LIKE 'PROFESSOR'";
        jpql+=!(matricula==null||matricula.isEmpty()) ? " AND u.matricula LIKE :matricula":"";
        TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class)
                .setFirstResult(min)
                .setMaxResults(quant);
        if(!(matricula==null||matricula.isEmpty())){
            query.setParameter("matricula","%"+matricula+"%");
        }
        return query.getResultList();
    }

    @Override
    public int quantProfessores(String matricula) {
        String jpql="SELECT COUNT(u.matricula) FROM Usuario u WHERE u.cargo LIKE 'PROFESSOR'";
        jpql+=!(matricula==null||matricula.isEmpty()) ? " AND u.matricula LIKE :matricula":"";
        TypedQuery<Long> query = em.createQuery(jpql, Long.class);
        if(!(matricula==null||matricula.isEmpty())){
            query.setParameter("matricula","%"+matricula+"%");
        }
        Long quant = query.getSingleResult();
        return quant.intValue();
    }
}
