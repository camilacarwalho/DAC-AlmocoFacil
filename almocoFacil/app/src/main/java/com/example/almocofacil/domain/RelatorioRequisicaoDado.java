package com.example.almocofacil.domain;

import com.example.almocofacil.domain.enums.StatusAutorizacao;

import java.time.LocalDate;
import java.util.Date;

public class RelatorioRequisicaoDado {

    private String data;
    private String nome;
    private StatusAutorizacao statusAutorizacao;
    private Long quantidade;

    public RelatorioRequisicaoDado() {}


    public RelatorioRequisicaoDado(String data, String nome, StatusAutorizacao statusAutorizacao, Long quantidade) {
        this.data = data;
        this.nome = nome;
        this.statusAutorizacao = statusAutorizacao;
        this.quantidade = quantidade;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
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

    @Override
    public String toString() {
        return "RelatorioRequisicaoDado{" +
                "data='" + data + '\'' +
                ", nome='" + nome + '\'' +
                ", statusAutorizacao=" + statusAutorizacao +
                ", quantidade=" + quantidade +
                '}';
    }
}
