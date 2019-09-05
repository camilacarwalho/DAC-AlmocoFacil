package br.edu.ifpb.service;

import br.edu.ifpb.domain.AutorizacaoRR;
import br.edu.ifpb.domain.enums.StatusAutorizacao;

import java.time.LocalDate;
import java.util.List;

public interface AutorizaoService {

    int quantAutorizacaoRR(LocalDate dataInicial, LocalDate dataFinal);
    List<AutorizacaoRR> listarAutorizacaoRR(int min, int quant,LocalDate dataInicial, LocalDate dataFinal);
}
