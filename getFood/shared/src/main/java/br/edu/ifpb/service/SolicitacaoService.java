package br.edu.ifpb.service;

import java.util.List;

import br.edu.ifpb.domain.Solicitacao;
import br.edu.ifpb.domain.enums.StatusRequisicao;

public interface SolicitacaoService {

	Solicitacao buscar(Long id);
	List<Solicitacao> listar();
	List<Solicitacao> buscarSolicitacoes(String requerente, StatusRequisicao statusRequisicao, int inicio, int termino);
	int quantBuscarSolicitacoes(String requerente, StatusRequisicao statusRequisicao);
	void negar(Solicitacao solicitacao);
	void autorizar(Solicitacao solicitacao);
	void autorizarCompulsoriamente(Solicitacao solicitacao);
	boolean podeAutorizar(Solicitacao solicitacao);
	boolean podeNegar(Solicitacao solicitacao);
	boolean isEncerrada(Solicitacao solicitacao);
}
