package br.edu.ifpb.service;

import br.edu.ifpb.domain.Refeicao;
import br.edu.ifpb.domain.Requisicao;
import java.time.LocalDate;
import java.util.List;

public interface RefeicaoService {
	
	void salvar(Refeicao refeicao);
        void atualizar(Refeicao refeicao);
        void remover(Refeicao refeicao);
        List<Refeicao> listar();
        Refeicao buscarPeloNome(String nome);
        List<Requisicao> refeicoesNoDia(LocalDate data);
        void atualizarRefeicao(Refeicao refeicao);
        
}
