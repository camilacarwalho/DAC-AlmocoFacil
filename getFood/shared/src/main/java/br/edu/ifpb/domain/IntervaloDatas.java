/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.domain;

/**
 *
 * @author alann
 */
public class IntervaloDatas {
    
     private String dataInicial;
    private String dataFinal;

    public IntervaloDatas(String dataInicial, String dataFinal) {
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
    }

    public IntervaloDatas(){}

    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    @Override
    public String toString() {
        return "IntervaloDatas{" +
                "dataInicial='" + dataInicial + '\'' +
                ", dataFinal='" + dataFinal + '\'' +
                '}';
    }
    
}
