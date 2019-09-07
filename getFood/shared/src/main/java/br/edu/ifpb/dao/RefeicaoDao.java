package br.edu.ifpb.dao;

import br.edu.ifpb.domain.Refeicao;
import java.time.LocalDate;
import java.util.List;

public interface RefeicaoDao extends DefaultDao<Refeicao> {
	
	Refeicao buscarPeloNome(String nome);
        List<Refeicao> refeicoesNoDia(LocalDate data);	

}
