package br.edu.ifpb.service;

import br.edu.ifpb.domain.Aluno;
import br.edu.ifpb.domain.Requisicao;
import br.edu.ifpb.domain.enums.StatusRequisicao;
import java.time.LocalDate;
import java.util.List;

public interface RequisicaoService {
	Requisicao buscar(long id);
        List<Requisicao> buscarRequisicoes(StatusRequisicao statusRequisicao, LocalDate dataHoje);
    boolean adicionarAluno(Requisicao requisicao, Aluno aluno);
    boolean definirAlunos(Requisicao requisicao, List<Aluno> alunos);
	boolean isEncerrada(Requisicao requisicao);
	void negar(Requisicao requisicao);
	void atualizar(Requisicao requisicao);
	void autorizar(Requisicao requisicao);
	void autorizarCompulsoriamente(Requisicao requisicao);
	boolean podeAutorizar(Requisicao requisicao);
	boolean podeNegar(Requisicao requisicao);
	boolean podeAlterar(Requisicao requisicao);
}
