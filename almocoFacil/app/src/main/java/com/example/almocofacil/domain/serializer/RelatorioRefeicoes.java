package com.example.almocofacil.domain.serializer;

import java.util.List;

public class RelatorioRefeicoes {

    private List<AutorizacaoRRJersey> listRefeicoes;

    public RelatorioRefeicoes(){}

    public RelatorioRefeicoes(List<AutorizacaoRRJersey> listRefeicoes) {
        this.listRefeicoes = listRefeicoes;
    }

    public List<AutorizacaoRRJersey> getListRefeicoes() {
        return listRefeicoes;
    }

    public void setListRefeicoes(List<AutorizacaoRRJersey> listRefeicoes) {
        this.listRefeicoes = listRefeicoes;
    }

    @Override
    public String toString() {
        return "RelatorioRefeicoes{" +
                "listRefeicoes=" + listRefeicoes +
                '}';
    }
}
