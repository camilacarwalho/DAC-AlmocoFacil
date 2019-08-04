package br.edu.ifpb.daoImpl.jpa;

import br.edu.ifpb.dao.UsuarioDao;
import br.edu.ifpb.domain.Usuario;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.Collections;
import java.util.List;

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
}
