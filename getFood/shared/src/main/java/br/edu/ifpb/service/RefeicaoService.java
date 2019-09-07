package br.edu.ifpb.service;

import br.edu.ifpb.domain.Refeicao;
import java.time.LocalDate;
import java.util.List;

public interface RefeicaoService {
	
	Refeicao buscarPeloNome(String nome);
        List<Refeicao> refeicoesNoDia(LocalDate data);

}
