package br.edu.ifpb.dao;

import java.util.List;

import br.edu.ifpb.domain.Solicitacao;
import br.edu.ifpb.domain.enums.StatusRequisicao;

public interface SolicitacaoDao extends DefaultDao<Solicitacao> {
	
	Solicitacao buscarPeloUsuario(Long id, String matricula);
	List<Solicitacao> buscarSolicitacoes(String requerente, StatusRequisicao statusRequisicao, int inicio, int quant);
	List<Solicitacao> buscarPelaMatricula(String matricula, int inicio, int quant, StatusRequisicao statusRequisicao);
	int quantBuscarSolicitacoes(String requerente, StatusRequisicao statusRequisicao);
	int quantSolicitacoresPelaMatricula(String matricula, StatusRequisicao statusRequisicao);
	
	
}
