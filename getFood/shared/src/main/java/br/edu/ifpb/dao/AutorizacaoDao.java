package br.edu.ifpb.dao;

import br.edu.ifpb.domain.Autorizacao;
import br.edu.ifpb.domain.AutorizacaoRR;
import br.edu.ifpb.domain.enums.StatusAutorizacao;

import java.time.LocalDate;
import java.util.List;

public interface AutorizacaoDao extends DefaultDao<Autorizacao> {

    List<AutorizacaoRR> listarAutorizacaoRR(int min, int quant, StatusAutorizacao statusAutorizacao,
                                            LocalDate dataInicial, LocalDate dataFinal);

    int quantAutorizacaoRR(StatusAutorizacao statusAutorizacao,
                           LocalDate dataInicial, LocalDate dataFinal);

}
