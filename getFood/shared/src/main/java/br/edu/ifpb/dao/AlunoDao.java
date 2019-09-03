package br.edu.ifpb.dao;

import br.edu.ifpb.domain.Aluno;

import java.util.List;

public interface AlunoDao extends DefaultDao<Aluno>{

        int quantBuscarAlunos();
        List<Aluno> buscarAlunos(int min, int quant, String matricula);
}
