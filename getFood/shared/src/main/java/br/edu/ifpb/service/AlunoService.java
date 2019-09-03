package br.edu.ifpb.service;

import br.edu.ifpb.domain.Aluno;

import java.util.List;

public interface AlunoService {
	Aluno buscarPelaMatricula(String matricula);
	int quantAlunos(String matricula);
	List<Aluno> buscarAlunos(int min, int quant,String matricula);
}
