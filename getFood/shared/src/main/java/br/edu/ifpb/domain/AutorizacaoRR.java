package br.edu.ifpb.domain;

import br.edu.ifpb.domain.enums.StatusAutorizacao;

import java.io.Serializable;
import java.time.LocalDate;

public class AutorizacaoRR implements Serializable {

    private LocalDate data;
    private String nome;
    private StatusAutorizacao statusAutorizacao;
    private Long quantidade;

    public AutorizacaoRR() {
    }

    public AutorizacaoRR(LocalDate data, String nome, StatusAutorizacao statusAutorizacao, Long quantidade) {
        this.data = data;
        this.nome = nome;
        this.statusAutorizacao = statusAutorizacao;
        this.quantidade = quantidade;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public StatusAutorizacao getStatusAutorizacao() {
        return statusAutorizacao;
    }

    public void setStatusAutorizacao(StatusAutorizacao statusAutorizacao) {
        this.statusAutorizacao = statusAutorizacao;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
}
