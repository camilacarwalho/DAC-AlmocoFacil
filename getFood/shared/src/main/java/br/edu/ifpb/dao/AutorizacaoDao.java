package br.edu.ifpb.dao;

import br.edu.ifpb.domain.Autorizacao;
import br.edu.ifpb.domain.AutorizacaoRR;
import br.edu.ifpb.domain.enums.StatusAutorizacao;

import java.time.LocalDate;
import java.util.List;

public interface AutorizacaoDao extends DefaultDao<Autorizacao> {

    List<AutorizacaoRR> listarAutorizacaoRR(int min, int quant,
                                            LocalDate dataInicial, LocalDate dataFinal);

    int quantAutorizacaoRR(
            LocalDate dataInicial, LocalDate dataFinal);
    
    public List<Autorizacao> buscar(LocalDate data);
    
    public void alterarStatus(Long id, StatusAutorizacao statusAutorizacao);

}
