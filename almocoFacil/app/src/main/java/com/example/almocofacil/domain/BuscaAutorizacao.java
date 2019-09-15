package com.example.almocofacil.domain;

import java.io.Serializable;
import java.util.Date;

public class BuscaAutorizacao implements Serializable {

    private static final long serialVersionUID = 3541492143821631550L;
    private Date data;
    private String reifeicao;

    public BuscaAutorizacao() {}

    public BuscaAutorizacao(Date data, String reifeicao) {
        this.data = data;
        this.reifeicao = reifeicao;
    }

    public Date getData() {return data;}
    public void setData(Date data) {this.data = data;}
    public String getReifeicao() {return reifeicao;}
    public void setReifeicao(String reifeicao) {this.reifeicao = reifeicao;}

}