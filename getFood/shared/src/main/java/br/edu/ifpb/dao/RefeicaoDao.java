package br.edu.ifpb.dao;

import br.edu.ifpb.domain.Refeicao;

public interface RefeicaoDao extends DefaultDao<Refeicao> {
	
	Refeicao buscarPeloNome(String nome);
	

}
