package br.edu.ifpb.dao;

import java.util.List;

import br.edu.ifpb.domain.Solicitacao;
import br.edu.ifpb.domain.enums.StatusRequisicao;

public interface SolicitacaoDao extends DefaultDao<Solicitacao> {
	
	List<Solicitacao> buscarSolicitacoes(String requerente, StatusRequisicao statusRequisicao, int inicio, int quant);
	int quantBuscarSolicitacoes(String requerente, StatusRequisicao statusRequisicao);
	
}
