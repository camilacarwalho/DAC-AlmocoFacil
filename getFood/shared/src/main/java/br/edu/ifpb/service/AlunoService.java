package br.edu.ifpb.service;

import br.edu.ifpb.domain.Aluno;

public interface AlunoService {
	Aluno buscarPelaMatricula(String matricula);
}
