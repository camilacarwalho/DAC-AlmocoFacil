package br.edu.ifpb.service;

import br.edu.ifpb.domain.Aluno;

import java.util.List;

public interface AlunoService {
	Aluno buscarPelaMatricula(String matricula);
	int quantAlunos();
	List<Aluno> buscarAlunos(int min, int quant);
}
