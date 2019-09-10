package br.edu.ifpb.service;

import br.edu.ifpb.domain.Autorizacao;
import br.edu.ifpb.domain.AutorizacaoRR;
import br.edu.ifpb.domain.enums.StatusAutorizacao;

import java.time.LocalDate;
import java.util.List;

public interface AutorizaoService {

    int quantAutorizacaoRR(LocalDate dataInicial, LocalDate dataFinal);
    List<AutorizacaoRR> listarAutorizacaoRR(int min, int quant,LocalDate dataInicial, LocalDate dataFinal);
    public void salvar(Autorizacao autorizacao);
    public List<Autorizacao> listar();
    public Autorizacao buscar(int id);
    public void Atualizar(Autorizacao autorizacao);
    public List<Autorizacao> buscar(LocalDate data);
    public void gerarAutorizacoes();
    public void alterarStatusAutorizacao(Long idAltorizacao, StatusAutorizacao statusAutorizacao);
    public void finalizarTodasAutorizacoesPendentesHoje();
}
