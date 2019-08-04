package br.edu.ifpb.controller;

import br.edu.ifpb.dao.UsuarioDao;
import br.edu.ifpb.domain.Usuario;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@RequestScoped
@Named
public class UsuarioController implements Serializable {

    @Inject
    private UsuarioDao usuarioDao;

    public List<Usuario> getListaDeUsuarios(){
        return usuarioDao.listar();
    }

}
