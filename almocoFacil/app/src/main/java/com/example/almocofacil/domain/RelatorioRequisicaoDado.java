package com.example.almocofacil.domain;

import com.example.almocofacil.domain.enums.StatusAutorizacao;

import java.time.LocalDate;
import java.util.Date;

public class RelatorioRequisicaoDado {

    private Date data;
    private Refeicao refeicao;
    private StatusAutorizacao status;
    private int quant;

    public RelatorioRequisicaoDado() {}


    public RelatorioRequisicaoDado(Date data, Refeicao refeicao, StatusAutorizacao status, int quant) {
        this.data = data;
        this.refeicao = refeicao;
        this.status = status;
        this.quant = quant;
    }

    public Date getData() {return data;}
    public void setData(Date data) {this.data = data;}
    public Refeicao getRefeicao() {return refeicao;}
    public void setRefeicao(Refeicao refeicao) {this.refeicao = refeicao;}
    public StatusAutorizacao getStatus() {return status;}
    public void setStatus(StatusAutorizacao status) {this.status = status;}
    public int getQuant() {return quant;}
    public void setQuant(int quant) {this.quant = quant;}
}
