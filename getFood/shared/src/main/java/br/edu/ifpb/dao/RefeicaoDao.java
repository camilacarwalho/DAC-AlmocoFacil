package br.edu.ifpb.dao;

import br.edu.ifpb.domain.Refeicao;
import br.edu.ifpb.domain.Requisicao;
import java.time.LocalDate;
import java.util.List;

public interface RefeicaoDao extends DefaultDao<Refeicao> {
	
	Refeicao buscarPeloNome(String nome);
        List<Requisicao> refeicoesNoDia(LocalDate data);	

}
