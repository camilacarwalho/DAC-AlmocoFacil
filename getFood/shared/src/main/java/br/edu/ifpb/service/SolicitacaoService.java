package br.edu.ifpb.service;

import java.util.List;

import br.edu.ifpb.domain.Requisicao;
import br.edu.ifpb.domain.Solicitacao;
import br.edu.ifpb.domain.enums.StatusRequisicao;

public interface SolicitacaoService {

	
	Solicitacao buscar(Long id);
	Solicitacao bucarPeloUsuario(Long id, String matricula);
	List<Solicitacao> listar();
	List<Solicitacao> buscarSolicitacoes(String requerente, StatusRequisicao statusRequisicao, int inicio, int termino);
	List<Solicitacao> buscarPelaMatricula(String matricula , StatusRequisicao statusRequisicao, int inicio, int termino);	
	int quantBuscarSolicitacoes(String requerente, StatusRequisicao statusRequisicao);
	int quantBuscarPelaMatricula(String matricula, StatusRequisicao statusRequisicao);
	void atualizar(Solicitacao solicitacao);
	void salvar(Solicitacao solicitacao);
	void atualizarStatusSolicitação(Solicitacao solicitacao);
	void negar(Solicitacao solicitacao);
	void autorizar(Solicitacao solicitacao);
	void autorizarCompulsoriamente(Solicitacao solicitacao);
	void negarRequisicao(Requisicao requisicao);
	void autorizarRequisicao(Requisicao requisicao);
	void autorizarCompulsoriamente(Requisicao requisicao);
	boolean podeAutorizar(Solicitacao solicitacao);
	boolean podeNegar(Solicitacao solicitacao);
	boolean isEncerrada(Solicitacao solicitacao);
}
