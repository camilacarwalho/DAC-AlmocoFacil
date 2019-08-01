package br.edu.ifpb.dao;

import br.edu.ifpb.domain.Usuario;

import java.util.List;

public interface UsuarioDao {

    void salvar(Usuario usuario);
    void remover(Usuario usuario);
    List<Usuario> listar();
    void atualizar(Usuario usuario);
    Usuario getById(String matricula);



}
