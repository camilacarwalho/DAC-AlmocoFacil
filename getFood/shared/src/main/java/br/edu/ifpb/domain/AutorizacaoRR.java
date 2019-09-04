package br.edu.ifpb.domain;

import br.edu.ifpb.domain.enums.StatusAutorizacao;

import java.io.Serializable;
import java.time.LocalDate;

public class AutorizacaoRR implements Serializable {

    private LocalDate data;
    private String nome;
    private StatusAutorizacao statusAutorizacao;
    private int quantidade;

    public AutorizacaoRR() {
    }

    public AutorizacaoRR(LocalDate data, String nome, StatusAutorizacao statusAutorizacao, int quantidade) {
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
