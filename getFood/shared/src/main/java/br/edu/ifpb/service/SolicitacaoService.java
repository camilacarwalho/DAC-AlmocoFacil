package br.edu.ifpb.service;

import java.util.List;

import br.edu.ifpb.domain.Solicitacao;
import br.edu.ifpb.domain.enums.StatusRequisicao;

public interface SolicitacaoService {
	
	List<Solicitacao> listar();
	List<Solicitacao> buscarSolicitacoes(String requerente, StatusRequisicao statusRequisicao);

}
