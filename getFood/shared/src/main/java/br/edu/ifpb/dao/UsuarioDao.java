package br.edu.ifpb.dao;

import br.edu.ifpb.domain.Usuario;

import java.util.List;

public interface UsuarioDao extends DefaultDao<Usuario> {

    List<Usuario> buscarProfessores(int min, int quant, String matricula);
    int quantProfessores(String matricula);

}
