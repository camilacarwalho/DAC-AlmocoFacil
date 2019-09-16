/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.domain;

import java.util.List;

/**
 *
 * @author alann
 */
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
        return "RelatorioRefeicoes{" + "listRefeicoes=" + listRefeicoes + '}';
    }
    
}
