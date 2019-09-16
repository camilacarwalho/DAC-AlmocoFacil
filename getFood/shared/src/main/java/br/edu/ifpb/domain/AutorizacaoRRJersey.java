/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.domain;

import br.edu.ifpb.domain.enums.StatusAutorizacao;
import java.time.LocalDate;

/**
 *
 * @author alann
 */
public class AutorizacaoRRJersey {
    
    private String data;
    private String nome;
    private StatusAutorizacao statusAutorizacao;
    private Long quantidade;

    public AutorizacaoRRJersey() {
        
    }

    public AutorizacaoRRJersey(String data, String nome, StatusAutorizacao statusAutorizacao, Long quantidade) {
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
        return "AutorizacaoRRJersey{" + "data=" + data + ", nome=" + nome + ", statusAutorizacao=" + statusAutorizacao + ", quantidade=" + quantidade + '}';
    }
    
}
