package br.edu.ifpb.dao;

import java.util.List;

import br.edu.ifpb.domain.Solicitacao;
import br.edu.ifpb.domain.enums.StatusRequisicao;

public interface SolicitacaoDao extends DefaultDao<Solicitacao> {
	
	List<Solicitacao> buscarSolicitacaos(String requerente, StatusRequisicao statusRequisicao);
	
}
