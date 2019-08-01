package br.edu.ifpb.daoImpl.jpa;

import br.edu.ifpb.dao.UsuarioDao;
import br.edu.ifpb.domain.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Collections;
import java.util.List;

public class UsuarioDaoJPA implements UsuarioDao {

    private EntityManager em;
    private EntityTransaction tr;

    public UsuarioDaoJPA(){
        this.em = Persistence
                .createEntityManagerFactory("Postgres")
                .createEntityManager();
        this.tr=em.getTransaction();
    }


    @Override
    public void salvar(Usuario usuario) {
        try{
            tr.begin();
            em.persist(usuario);
            tr.commit();
        }catch (Exception ex){
            ex.printStackTrace();
            tr.rollback();
        }

    }

    @Override
    public void remover(Usuario usuario) {
        try{
            tr.begin();
            Usuario morto = getById(usuario.getMatricula());
            em.persist(usuario);
            tr.commit();
        }catch (Exception ex){
            ex.printStackTrace();
            tr.rollback();
        }
    }

    @Override
    public List<Usuario> listar() {
        try{
            tr.begin();
            List<Usuario> usuarios = em
                    .createQuery("SELECT u FROM Usuario u")
                    .getResultList();
            tr.commit();
            return usuarios;
        }catch (Exception ex){
            ex.printStackTrace();
            tr.rollback();
            return Collections.emptyList();
        }
    }

    @Override
    public void atualizar(Usuario usuario) {
        try{
            tr.begin();
            em.merge(usuario);
            tr.commit();
        }catch (Exception ex){
            ex.printStackTrace();
            tr.rollback();
        }
    }

    @Override
    public Usuario getById(String matricula) {
        try{
            tr.begin();
            Usuario encontrado = em.find(Usuario.class,matricula);
            tr.commit();
            return encontrado;
        }catch (Exception ex){
            ex.printStackTrace();
            tr.rollback();
            return null;
        }
    }
}
