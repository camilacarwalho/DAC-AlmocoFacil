package br.edu.ifpb.service;

import br.edu.ifpb.domain.Requisicao;

public interface RequisicaoService {
	Requisicao buscar(long id);
	boolean isEncerrada(Requisicao requisicao);
	void negar(Requisicao requisicao);
	void autorizar(Requisicao requisicao);
	void autorizarCompulsoriamente(Requisicao requisicao);
	boolean podeAutorizar(Requisicao requisicao);
	boolean podeNegar(Requisicao requisicao);
}
